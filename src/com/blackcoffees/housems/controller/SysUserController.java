package com.blackcoffees.housems.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blackcoffees.housems.db.entity.SysUser;
import com.blackcoffees.housems.service.ISysUserLoginLogService;
import com.blackcoffees.housems.service.ISysUserService;
import com.blackcoffees.housems.util.Pager;
import com.blackcoffees.housems.util.ReturnJsonData;
import com.blackcoffees.housems.util.SessionUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("sysUser")
public class SysUserController {

	@Autowired
	private ISysUserService service;
	
	@Autowired
	private ISysUserLoginLogService userLoginLogService;
	
	@RequestMapping("userLogin")
	@ResponseBody
	public String userLogin(SysUser user, HttpSession session){
		Map<String, Object> result = ReturnJsonData.getReturnMap();
		user = service.userLogin(user);
		if(user != null){
			String hms = SessionUtil.getSessionValue(user.getLast_login(), user.getId());
			session.setAttribute("hms", hms);
			session.setAttribute("hms_username", user.getUsername());
			result.put("message", "登录成功");
			result.put("succ", true);
		}
		else {
			result.put("message", "登录失败");
		}
		return JSONObject.fromObject(result).toString();
	}
	
	@RequestMapping("loginSucc")
	public ModelAndView loginSucc(){
		return new ModelAndView("index");
	}
	
	@RequestMapping("userLoginOut")
	@ResponseBody
	public String userLoginOut(HttpSession session){
		Map<String, Object> result = ReturnJsonData.getReturnMap();
		session.setAttribute("hms", null);
		session.setAttribute("hms_username", null);
		result.put("succ", true);
		result.put("message", "退出登陆成功");
		return JSONObject.fromObject(result).toString();
	}
	
	@RequestMapping("getAllUser")
	@ResponseBody
	public String getAllUser(Pager pager){
		List<SysUser> list = service.getAllUser(pager);
		return ReturnJsonData.returnJsonDataSigleList(pager, list);
	}
	
	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(SysUser user){
		return JSONObject.fromObject(service.addUser(user)).toString();
	}
	
	@RequestMapping("updateUserStatus")
	@ResponseBody
	public String updateUserStatus(SysUser user){
		Map<String, Object> result = ReturnJsonData.getReturnMap();
		if(service.updateUserStatus(user) > 0){
			result.put("succ", true);
			result.put("message", "修改用户状态成功");
		}
		else{
			result.put("message", "修改用户状态失败");
		}
		return JSONObject.fromObject(result).toString();
	}
	
	@RequestMapping("resetPassword")
	@ResponseBody
	public String resetPassword(SysUser user){
		Map<String, Object> result = ReturnJsonData.getReturnMap();
		if(service.updateResetPassword(user) > 0){
			result.put("succ", true);
			result.put("message", "重置用户密码成功");
		}
		else{
			result.put("message", "重置用户密码失败");
		}
		return JSONObject.fromObject(result).toString();
	}
}
