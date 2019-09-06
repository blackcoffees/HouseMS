package com.blackcoffees.housems.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.blackcoffees.housems.db.entity.SysUser;
import com.blackcoffees.housems.service.ISysUserService;
import com.blackcoffees.housems.util.SessionUtil;

public class UserLoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	private ISysUserService userService;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("user", null);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String hms_username = String.valueOf(session.getAttribute("hms_username"));
		String hms = String.valueOf(session.getAttribute("hms"));
		if(hms == null || hms == "" || hms_username == "" || hms_username == null || hms == "null" || hms_username == "null"){
			response.setHeader("SESSIONSTATUS", "LOGIN");
			response.setHeader("CONTENTPATH", request.getContextPath() + "/back/login.jsp");
			return false;
		}
		else{
			SysUser user = userService.getUserByUsername(hms_username);
			String md5_hms = SessionUtil.getSessionValue(user.getLast_login(), user.getId());
			if(md5_hms.equals(hms)){
				request.getSession().setAttribute("user", user);
				return true;
			}
		}
		response.setHeader("SESSIONSTATUS", "LOGIN");
		response.setHeader("CONTENTPATH", request.getContextPath() + "/back/login.jsp");
		return false;
	}

}
