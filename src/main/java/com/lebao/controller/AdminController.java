package com.lebao.controller;

import com.google.gson.Gson;
import com.lebao.bean.SysMenuBean;
import com.lebao.bean.SysUserBean;
import com.lebao.common.Constant;
import com.lebao.service.i.ISysService;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController  {
	@Autowired
	ISysService sysService;
	private Logger logger = Logger.getLogger(AdminController.class);
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		//initSideMenu(view);
		view.setViewName("admin/home");
		return view;
	}

	@RequestMapping(value={"","/"})
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		//initSideMenu(view);
		view.setViewName("admin/login");
		return view;
	}

	@RequestMapping("/orderList")
	public ModelAndView orderList(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		//initSideMenu(view);
		view.setViewName("admin/orderList");
		return view;
	}
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView();
		try{
			/*
			Subject user = SecurityUtils.getSubject();
			SysUserBean sub =  (SysUserBean) user.getPrincipal() ;
			logger.debug(new Gson().toJson(sub));
			List<SysMenuBean> menus =sysService.buildMenu( sysService.getMenusByUserId(sub.getP_id())) ;

			view.setViewName("admin/index");
			view.addObject("sysUser", sub);
			view.addObject("sysMenus", menus);
			*/
		}catch(Exception e){
			logger.error("load menu fail" , e);
			e.printStackTrace();
		}
		return view ;
	}
	
	/*
	 * 用于js脚本的全局变量
	 */
	@RequestMapping(value = "/static/global.js", produces = { "application/x-javascript", "text/javascript", "application/javascript" })
	@ResponseBody
	public String jsGlobal(WebRequest webRequest) {
		StringBuilder sb = new StringBuilder();
		sb.append("var G_CTX_ROOT = '").append(webRequest.getContextPath()).append("';\n");
		return sb.toString();
	}


}
