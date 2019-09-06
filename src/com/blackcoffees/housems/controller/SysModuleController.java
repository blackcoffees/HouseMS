package com.blackcoffees.housems.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blackcoffees.housems.db.entity.SysModule;
import com.blackcoffees.housems.db.entity.SysUser;
import com.blackcoffees.housems.db.query.ModuleTreeNode;
import com.blackcoffees.housems.service.ISysModuleService;
import com.blackcoffees.housems.util.Pager;
import com.blackcoffees.housems.util.ReturnJsonData;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("sysModule")
public class SysModuleController {

	@Autowired
	private ISysModuleService service;
	
	@RequestMapping("getAllModule")
	@ResponseBody
	public String getAllModule(Pager pager){
		List<SysModule> list = service.getAllModule(pager);
		return ReturnJsonData.returnJsonDataSigleList(pager, list);
	}
	
	@RequestMapping("addModule")
	@ResponseBody
	public String addModule(SysModule module, HttpSession session){
		SysUser user = (SysUser)session.getAttribute("user");
		Map<String, Object> result = service.addModule(module, user);
		return JSONObject.fromObject(result).toString();
	}
	
	@RequestMapping("updateModuleStatus")
	@ResponseBody
	public String updateModuleUpdate(SysModule module){
		Map<String, Object> result = ReturnJsonData.getReturnMap();
		if(service.updateModuleStatus(module) > 0){
			result.put("succ", true);
			result.put("message", "修改成功");
		}
		return JSONObject.fromObject(result).toString();
	}
	
	@RequestMapping("getModuleTree")
	@ResponseBody
	public String getModuleTree(HttpSession session, int user_id){
		return ReturnJsonData.returnJsonDataMultipleList(new Pager(), service.getModuleTree(user_id));
	}
	
	@RequestMapping("getRootChildModule")
	@ResponseBody
	public String getRootChildModule(){
		return ReturnJsonData.returnJsonDataSigleList(new Pager(), service.getRootChildModule());
	}
	
	@RequestMapping("getUserModules")
	@ResponseBody
	public String getUserModules(HttpSession session){
		SysUser user = (SysUser) session.getAttribute("user");
		List<ModuleTreeNode> list = service.getUserModule(user.getId());
		return ReturnJsonData.returnJsonDataMultipleList(new Pager(), list);
	}
}
