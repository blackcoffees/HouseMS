package com.blackcoffees.housems.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.blackcoffees.housems.db.entity.SysUserPermission;

public interface ISysUserPermissionService {
	public List<SysUserPermission> getUserModule(int user_id);
	
	public int addUserPermission(SysUserPermission permission);
	
	public int deleteUserPermission(SysUserPermission permission);
	
	public int checkUserPermission(SysUserPermission permission);
	
	public Map<String, Object> updateUserPermission(int[] module_ids, int user_id);
}
