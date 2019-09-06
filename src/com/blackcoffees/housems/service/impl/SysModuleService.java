package com.blackcoffees.housems.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.SysModuleMapper;
import com.blackcoffees.housems.db.entity.SysModule;
import com.blackcoffees.housems.db.entity.SysUser;
import com.blackcoffees.housems.db.entity.SysUserPermission;
import com.blackcoffees.housems.db.query.ModuleTreeNode;
import com.blackcoffees.housems.service.ISysModuleService;
import com.blackcoffees.housems.service.ISysUserPermissionService;
import com.blackcoffees.housems.service.ISysUserService;
import com.blackcoffees.housems.util.DateUtil;
import com.blackcoffees.housems.util.Pager;
import com.blackcoffees.housems.util.ReturnJsonData;

@Service("sysModuleService")
public class SysModuleService implements ISysModuleService{

	@Autowired
	private SysModuleMapper mapper;
	
	@Autowired
	private ISysUserPermissionService sysUserPermissionService;
	
	@Autowired
	private ISysUserService userService;

	@Override
	public List<SysModule> getAllModule(Pager pager) {
		return mapper.getAllModule(pager);
	}

	@Override
	public Map<String, Object> addModule(SysModule module, SysUser user) {
		// TODO Auto-generated method stub
		Map<String, Object> result = ReturnJsonData.getReturnMap();
		if(module.getId() > 0){
			return this.updateModule(module, user);
		}
		else if(this.checkModuleUnique(module) <= 0){
			module.setStatus(1);
			module.setCreated(DateUtil.getNow());
			module.setSys_user_id(user.getId());
			int module_id = mapper.addModule(module);
			if(module_id > 0){
				// 自动给root分配权限
				SysUser rootUser = userService.getUserByUsername("root");
				SysUserPermission rootPermission = new SysUserPermission();
				rootPermission.setModule_id(module_id);
				rootPermission.setUser_id(rootUser.getId());
				sysUserPermissionService.addUserPermission(rootPermission);
				//
				result.put("succ", true);
				result.put("message", "新增成功");
				return result;
			}
			else{
				result.put("message", "新增失败");
				return result;
			}
		}
		else{
			result.put("message", "模块名称或地址重复");
			return result;
		}
	}

	@Override
	public int checkModuleUnique(SysModule module) {
		// TODO Auto-generated method stub
		return mapper.checkModuleUnique(module);
	}

	@Override
	public int updateModuleStatus(SysModule module) {
		// TODO Auto-generated method stub
		module.setUpdated(DateUtil.getNow());
		return mapper.updateModuleStatus(module);
	}

	@Override
	public Map<String, Object> updateModule(SysModule module, SysUser user) {
		// TODO Auto-generated method stub
		Map<String, Object> result = ReturnJsonData.getReturnMap();
		module.setSys_user_id(user.getId());
		module.setUpdated(DateUtil.getNow());
		if(mapper.updateModule(module) > 0){
			result.put("succ", true);
			result.put("message", "修改模块成功");
			return result;
		}
		else {
			result.put("message", "修改模块失败");
			return result;
		}
		
	}

	@Override
	public List<SysModule> getModuleTreeNode(int parent_id) {
		// TODO Auto-generated method stub
		return mapper.getModuleTreeNode(parent_id);
	}

	@Override
	public List<ModuleTreeNode> getModuleTree(int user_id) {
		// TODO Auto-generated method stub
		// 用户权限的模块
		List<SysUserPermission> userModules = sysUserPermissionService.getUserModule(user_id);
		List<Integer> userModuleIDs = new ArrayList<>();
		for(int i=0;i<userModules.size();i++){
			userModuleIDs.add(userModules.get(i).getModule_id());
		}
		// 保存模块树结构
		List<ModuleTreeNode> treeModules = new ArrayList<ModuleTreeNode>();
		// 获得所有的根节点
		List<SysModule> rootModules = this.getModuleTreeNode(0);
		for(int index=0;index<rootModules.size();index++){
			ModuleTreeNode parentNode = new ModuleTreeNode();
			parentNode.setText(rootModules.get(index).getName());
			parentNode.setId(rootModules.get(index).getId());
			List<SysModule> childModules = this.getModuleTreeNode(rootModules.get(index).getId());
			List<ModuleTreeNode> childTreeModules = new ArrayList<>();
			for(int j=0;j<childModules.size();j++){
				ModuleTreeNode childNode = new ModuleTreeNode();
				childNode.setText(childModules.get(j).getName());
				childNode.setId(childModules.get(j).getId());
				if(userModuleIDs.contains(childModules.get(j).getId())){
					childNode.getState().put("selected", true);
				}
				childTreeModules.add(childNode);
			}
			parentNode.setChildren(childTreeModules);
			treeModules.add(parentNode);
		}
		return treeModules;
	}

	@Override
	public List<SysModule> getRootChildModule() {
		// TODO Auto-generated method stub
		return mapper.getRootChildModule();
	}

	@Override
	public List<SysModule> getRootModuleByIds(int[] module_ids) {
		// TODO Auto-generated method stub
		return mapper.getRootModuleByIds(module_ids);
	}

	@Override
	public List<ModuleTreeNode> getUserModule(int user_id) {
		// TODO Auto-generated method stub
		List<SysModule> userModules = mapper.getUserModule(user_id);
		List<ModuleTreeNode> parentList = new ArrayList<ModuleTreeNode>();
		for(int i=0;i<userModules.size();i++){
			ModuleTreeNode node = new ModuleTreeNode();
			node.setText(userModules.get(i).getName());
			node.setHref(userModules.get(i).getHref());
			node.setId(userModules.get(i).getId());
			node.setParent_id(userModules.get(i).getParent_id());
			// 根节点
			if(userModules.get(i).getParent_id() == 0){
				parentList.add(node);
			}
			else{
				for(int j=0;j<parentList.size();j++){
					if(parentList.get(j).getId() == userModules.get(i).getParent_id()){
						parentList.get(j).getChildren().add(node);
						break;
					}
				}
			}
		}
		return parentList;
	}
}
