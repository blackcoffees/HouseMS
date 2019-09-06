package com.blackcoffees.housems.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blackcoffees.housems.db.entity.SysUser;
import com.blackcoffees.housems.db.entity.SysUserPermission;
import com.blackcoffees.housems.service.ISysUserPermissionService;
import com.blackcoffees.housems.util.ReturnJsonData;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("sysUserPermission")
public class SysUserPermissionController {

	@Autowired
	private ISysUserPermissionService service;
	
	@RequestMapping("addUserPermission")
	@ResponseBody
	public String addUserPermission(SysUserPermission permission, HttpSession session){
		permission.setUser_id(((SysUser)session.getAttribute("user")).getId());
		Map<String, Object> result = ReturnJsonData.getReturnMap();
		if(service.addUserPermission(permission) > 0){
			result.put("succ", true);
			result.put("message", "权限分配成功");
		}
		else{
			result.put("message", "权限分配失败");
		}
		return JSONObject.fromObject(result).toString();
	}
	
	@RequestMapping("updateUserPermission")
	@ResponseBody
	public String updateUserPermission(int[] moduleIds, int user_id){
		return JSONObject.fromObject(service.updateUserPermission(moduleIds, user_id)).toString();
	}
}
