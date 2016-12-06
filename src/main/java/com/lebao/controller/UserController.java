//package com.lebao.controller;
//
//import com.lebao.bean.SearchParam;
//import com.lebao.bean.UserBean;
//import com.lebao.common.dbhelp.page.Page;
//import com.lebao.common.utils.TimeUtil;
//import com.lebao.modules.user.dao.UserDao;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/user/")
//public class UserController extends BaseController {
//	private Logger logger = Logger.getLogger(UserController.class);
//
//	@Autowired
//	private UserDao userDao;
//	@RequestMapping("/list")
//	public ModelAndView userList() {
//		ModelAndView view = new ModelAndView();
//		view.addObject("title", "会员管理>>会员查询");
//		view.setViewName("admin/userList");
//		return view;
//	}
//
//	@RequestMapping(value="/query",produces="application/json;charset=UTF-8")
//	@ResponseBody
//	public String userQuery(HttpServletRequest request) {
//		Map<String, Object> obj = this.getParametersStartWidth(request,
//				"s_");
//		String userPhone = (String) obj.get("userPhone");
//		String userAccount = (String) obj.get("account");
//		String userName = (String) obj.get("userName");
//		String userId = (String) obj.get("userId");
//		DataTableVo dt = this.parseData4DT(request);
//		int start = dt.getiDisplayStart();
//		int length = dt.getiDisplayLength();
//		int curPage = 0;
//		if (dt.getiDisplayStart() > 0) {
//			curPage = start / length + 1;
//		}
//		String json = null;
//		try {
//			SearchParam s = new SearchParam();
//			if(dt.getSortField().equals("createTime")){
//				s.setSortField("p_create_time");
//			}
//			if(dt.getSortField().equals("userType")){
//				s.setSortField("p_type");
//			}
//			if(dt.getSortField().equals("lastLoginTime")){
//				s.setSortField("p_lastlogin_time");
//			}
//			s.setSortType(dt.getSortType());
//			if (StringUtils.isNotBlank(userPhone)) {
//				s.setPhone(userPhone.trim());
//			}
//			if (StringUtils.isNotBlank(userAccount)) {
//				s.setAccount(userAccount);
//			}
//			if (StringUtils.isNotBlank(userName)) {
//				s.setUserName(userName);
//			}
//			if (StringUtils.isNotBlank(userId)) {
//				s.setId(userId);
//			}
//			s.setPageNow(curPage);
//			s.setPageSize(length);
//			Page<UserBean> pages = userService.getUsers(s);
//			dt.setData(pages.getData());
//			dt.setiTotalRecords(dt.getiTotalRecords());
//			dt.setiTotalRecords(pages.getRecordCount());
//			json = formateData2DT(dt);
//		} catch (Exception e) {
//			logger.error(e);
//		}
//		return json;
//	}
//
//	@RequestMapping("/add")
//	@ResponseBody
//	public String add(@Valid  UserBean userBean) {
//		try {
//			userService.addUser(userBean);
//			return this.buildSuccessMessage("classes_add_success",
//						ResultModal.MESSAGE);
//		} catch (Exception e) {
//			logger.error("添加班级失败", e);
//			return  this.buildFailMessage("classes_add_fail", ResultModal.MESSAGE);
//		}
//	}
//
//	@RequestMapping(value = "/preUpdate/{id}")
//	public ModelAndView preUpdate(@PathVariable String id) {
//
//		ModelAndView view = new ModelAndView();
//		view.addObject("title", "会员管理>>会员信息修改");
//
//		UserBean temp = new UserBean();
//		temp.setP_id(id);
//		UserBean ub=null;
//		try {
//			ub = userService.getUser(temp);
//			view.addObject("user", ub);
//
//		} catch (Exception e) {
//			logger.error("获取会员信息失败", e);
//		}
//		view.setViewName("admin/user/update");
//		return view;
//	}
//	@RequestMapping(value = "/update")
//	public Object update(UserBean ub) {
//	    try {
//			System.out.println("修改");
//			userService.updUser(ub);
//		}catch (Exception e){
//			logger.error("更新会员信息失败", e);
//		}
//		//view.setViewName("admin/user/update");
//		return "redirect:/user/list";
//	}
//
//	@RequestMapping("/hyTimeUpdate")
//	@ResponseBody
//	public String hyTimeUpdate(HttpServletRequest request) {
//		try {
//			String p_id=request.getParameter("p_id");
//			int p_month=Integer.valueOf(request.getParameter("p_month"));
//			//System.out.println(p_id+","+p_month);
//			UserBean temp=new UserBean();
//			temp.setP_id(p_id);
//			UserBean user=userService.getUser(temp);
//
//			String hyEndTime=user.getP_hy_end_time();
//			if(StringUtils.isBlank(hyEndTime)){
//				//会员到期时间为空
//             // String currentTime= TimeUtil.format(new Date(), TimeUtil.TARGET_1);
//				String currentTime= TimeUtil.now();
//				hyEndTime=TimeUtil.addDays(currentTime,p_month*31);
//				hyEndTime=TimeUtil.format(hyEndTime,TimeUtil.SOURCE_1,TimeUtil.TARGET_1);
//			}else {
//				//会员到期时间不为空
//				if(Long.valueOf(TimeUtil.format(hyEndTime,TimeUtil.TARGET_1,TimeUtil.SOURCE_1))<=Long.valueOf(TimeUtil.now())){
//					hyEndTime=TimeUtil.addDays(TimeUtil.now(),p_month*31);
//					hyEndTime=TimeUtil.format(hyEndTime,TimeUtil.SOURCE_1,TimeUtil.TARGET_1);
//
//			 }else {
//					hyEndTime=TimeUtil.format(hyEndTime,TimeUtil.TARGET_1,TimeUtil.SOURCE_1);
//					hyEndTime=TimeUtil.addDays(hyEndTime,p_month*31);
//					hyEndTime=TimeUtil.format(hyEndTime,TimeUtil.SOURCE_1,TimeUtil.TARGET_1);
//				}
//
//			}
//            user.setP_type("1");
//			user.setP_hy_end_time(hyEndTime);
//			userService.updUser(user);
//
//
//			return this.buildSuccessMessage("classes_add_success",
//					ResultModal.MESSAGE);
//		} catch (Exception e) {
//			logger.error("添加班级失败", e);
//			return  this.buildFailMessage("classes_add_fail", ResultModal.MESSAGE);
//		}
//	}
//
//}
