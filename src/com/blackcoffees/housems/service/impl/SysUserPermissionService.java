package com.blackcoffees.housems.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.SysUserPermissionMapper;
import com.blackcoffees.housems.db.entity.SysModule;
import com.blackcoffees.housems.db.entity.SysUserPermission;
import com.blackcoffees.housems.service.ISysModuleService;
import com.blackcoffees.housems.service.ISysUserPermissionService;
import com.blackcoffees.housems.util.DateUtil;
import com.blackcoffees.housems.util.ReturnJsonData;

@Service("sysUserPermission")
public class SysUserPermissionService implements ISysUserPermissionService{

	@Autowired
	private SysUserPermissionMapper mapper;
	
	@Autowired
	private ISysModuleService moduleService;

	@Override
	public List<SysUserPermission> getUserModule(int user_id) {
		// TODO Auto-generated method stub
		return mapper.getUserModule(user_id);
	}

	@Override
	public int addUserPermission(SysUserPermission permission) {
		// TODO Auto-generated method stub
		permission.setCreated(DateUtil.getNow());
		return mapper.addUserPermission(permission);
	}

	@Override
	public int deleteUserPermission(SysUserPermission permission) {
		// TODO Auto-generated method stub
		return mapper.deleteUserPermission(permission);
	}

	@Override
	public int checkUserPermission(SysUserPermission permission) {
		// TODO Auto-generated method stub
		return mapper.checkUserPermission(permission);
	}

	@Override
	public Map<String, Object> updateUserPermission(int[] moduleIds, int user_id) {
		// TODO Auto-generated method stub
		
		List<Integer> childModuleIds = Arrays.stream(moduleIds).boxed().collect(Collectors.toList());
		// 获取所有一级目录
		List<SysModule> rootModules = moduleService.getRootModuleByIds(moduleIds);
		for(int index=0;index<rootModules.size();index++){
			if(childModuleIds.contains(rootModules.get(index).getId())){
				childModuleIds.remove(rootModules.get(index).getId());
			}
			List<SysModule> rootChildModules = moduleService.getModuleTreeNode(rootModules.get(index).getId());
			// 检查一级目录下的二级目录
			for(int j=0;j<rootChildModules.size();j++){
				SysUserPermission permission = new SysUserPermission();
				permission.setModule_id(rootChildModules.get(j).getId());
				permission.setUser_id(user_id);
				if(this.checkUserPermission(permission) > 0){
					this.deleteUserPermission(permission);
				}
				else{
					this.addUserPermission(permission);
				}
			}
		}
		// 二级目录
		for(int index=0;index<childModuleIds.size();index++){
			SysUserPermission childPermission = new SysUserPermission();
			childPermission.setModule_id(childModuleIds.get(index));
			childPermission.setUser_id(user_id);
			if(this.checkUserPermission(childPermission) > 0){
				this.deleteUserPermission(childPermission);
			}
			else{
				this.addUserPermission(childPermission);
			}
		}
		
		Map<String, Object> result = ReturnJsonData.getReturnMap();
		result.put("succ", true);
		result.put("message", "分配权限成功");
		return result;
	}
}
