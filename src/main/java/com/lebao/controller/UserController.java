package com.lebao.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.lebao.common.utils.CommonUtil;
import com.lebao.common.utils.UrlUtil;
import com.lebao.converter.UserConverter;
import com.lebao.file.AppConfig;
import com.lebao.po.*;
import com.lebao.service.*;
import com.lebao.vo.SysUserVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.vo.UserVo;

/**
 * Author: zr Date : 2017/1/10 18:00
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDepartmentRelService userDepartmentRelService;
    @Autowired
    private EduLevelService eduLevelService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private UserConverter userConverter;

    /**
     * 页面入口
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.addObject("title", "系统管理>>用户查询");
        view.setViewName("admin/user/index");
        return view;
    }

    @RequestMapping("/userQR")
    public ModelAndView userQR() {
        ModelAndView view = new ModelAndView();
        //view.addObject("title", "系统管理>>用户查询");
        view.setViewName("admin/user/userQR");
        return view;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam("module") String module, @RequestParam("action") String action, @RequestParam(value = "id", required = false) Long id) {

        ModelAndView view = new ModelAndView();
        List<EduLevel> eduLevelList = eduLevelService.findAll();
        List<Position> positionList = positionService.findAll();
        List<Department> departmentList = departmentService.findAll();
        view.addObject("eduLevelList", eduLevelList);
        view.addObject("positionList", positionList);
        view.addObject("departmentList", departmentList);
        if ("save".equals(action)) {
            view.setViewName("admin/user/edit");
        } else if ("update".equals(action)) {
            UserVo userVo = userService.findOne(id);
            view.addObject("userVo", userVo);
            view.setViewName("admin/user/edit");
        }
        return view;
    }

    /**
     * 分页数据查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/query", produces = "plain/text; charset=UTF-8")
    @ResponseBody
    public String query(HttpServletRequest request) {
        Map<String, Object> obj = this.getParametersStartWidth(request, "s_");
        String name = (String) obj.get("name");
        BaseController.DataTableVo dt = this.parseData4DT(request);
        int start = dt.getiDisplayStart();
        int length = dt.getiDisplayLength();
        int curPage = 0;
        if (dt.getiDisplayStart() > 0) {
            curPage = start / length + 1;
        }
        String json = null;
        try {
            SearchBean s = new SearchBean();
            if (StringUtils.isNotBlank(name)) {
                s.getParamMap().put("name", name);
            }
            if (dt.getSortField().equals("user_id")) {
                s.setSortField("id");
            }
            s.setSortType(dt.getSortType());
            s.setCurrentPage(curPage);
            s.setPageSize(length);
            Page<UserVo> pages = userService.getPage(s);
            dt.setData(pages.getData());
            dt.setiTotalRecords(dt.getiTotalRecords());
            dt.setiTotalRecords(pages.getRecordCount());
            json = formateData2DT(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }


    /**
     * 添加用户
     *
     * @param name
     * @param pic
     * @param sex
     * @param eduLevel
     * @param position
     * @param phone
     * @param desc
     * @param departmentIds
     * @return
     */
    @RequestMapping(value = "/save", produces = "plain/text; charset=UTF-8")
    @ResponseBody
    public String save(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "pic", required = true) String pic,
            @RequestParam(value = "sex", required = true) Integer sex,
            @RequestParam(value = "eduLevel", required = true) Long eduLevel,
            @RequestParam(value = "position", required = true) Long position,
            @RequestParam(value = "phone", required = true) String phone,
            @RequestParam(value = "desc", required = true) String desc,
            @RequestParam(value = "departmentIds[]", required = false) Long departmentIds[]) {
        try {
            UserVo userVo = new UserVo();
            userVo.setName(name);
            userVo.setPic(pic);
            userVo.setSex(sex);
            userVo.setEduLevel(eduLevel);
            userVo.setPosition(position);
            userVo.setPhone(phone);
            userVo.setRemark(desc);
            User user = userConverter.convert2P(userVo);
            userService.save(user);
            if (!CommonUtil.isEmpty(Arrays.asList(departmentIds))) {
                for (Long id : departmentIds) {
                    UserDepartmentRel userDepartmentRel = new UserDepartmentRel();
                    userDepartmentRel.setUid(user.getId());
                    userDepartmentRel.setDid(id);
                    userDepartmentRelService.save(userDepartmentRel);
                }
            }
            String qr = userService.saveQR(user);
            user.setQr(qr);
            userService.update(user);
            return this.buildSuccessMessage("员工添加成功", ResultModal.MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return this.buildFailMessage("员工添加失败", ResultModal.MESSAGE);
        }
    }

    /**
     * @param id
     * @param name
     * @param pic
     * @param sex
     * @param eduLevel
     * @param position
     * @param phone
     * @param desc
     * @param departmentIds
     * @return
     */
    @RequestMapping(value = "/update", produces = "plain/text; charset=UTF-8")
    @ResponseBody
    public String update(
            @RequestParam(value = "id", required = true) Long id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "pic", required = true) String pic,
            @RequestParam(value = "sex", required = true) Integer sex,
            @RequestParam(value = "eduLevel", required = true) Long eduLevel,
            @RequestParam(value = "position", required = true) Long position,
            @RequestParam(value = "phone", required = true) String phone,
            @RequestParam(value = "desc", required = true) String desc,
            @RequestParam(value = "departmentIds[]", required = false) Long departmentIds[]) {
        try {
            UserVo userVo = userService.findOne(id);
            if (userVo == null) {
                return this.buildFailMessage("员工不存在", ResultModal.MESSAGE);
            }
            userVo.setName(name);
            userVo.setPic(pic);
            userVo.setSex(sex);
            userVo.setEduLevel(eduLevel);
            userVo.setPosition(position);
            userVo.setPhone(phone);
            userVo.setRemark(desc);
            User user = userConverter.convert2P(userVo);
            userService.save(user);
            List<UserDepartmentRel> oldUserDepartmentRelList = userDepartmentRelService
                    .findByUid(userVo.getId());
            List<Long> oldDepartmentIds = new ArrayList<Long>();
            for (UserDepartmentRel userDepartmentRel : oldUserDepartmentRelList) {
                oldDepartmentIds.add(userDepartmentRel.getId());
            }
            userDepartmentRelService.deleteBatch(oldDepartmentIds);
            for (Long did : departmentIds) {
                UserDepartmentRel userDepartmentRel = new UserDepartmentRel();
                userDepartmentRel.setUid(userVo.getId());
                userDepartmentRel.setDid(did);
                userDepartmentRelService.save(userDepartmentRel);
            }
            if (userService.deleteQR(user.getId())) {
                String qr = userService.saveQR(user);
                user.setQr(qr);
                userService.update(user);
            }
            return this.buildSuccessMessage("员工更新成功", ResultModal.MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return this.buildFailMessage("员工更新失败", ResultModal.MESSAGE);
        }
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(value = "id", required = true) Long id) {
        try {
            userService.delete(id);
            return this.buildSuccessMessage("员工删除成功",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return this.buildFailMessage("员工删除失败", ResultModal.MESSAGE);
        }
    }
}
