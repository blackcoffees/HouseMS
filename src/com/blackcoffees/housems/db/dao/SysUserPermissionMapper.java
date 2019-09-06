package com.blackcoffees.housems.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blackcoffees.housems.db.entity.SysUserPermission;

public interface SysUserPermissionMapper {
	public List<SysUserPermission> getUserModule(@Param("user_id")int user_id);
	
	public int addUserPermission(@Param("permission")SysUserPermission permission);
	
	public int deleteUserPermission(@Param("permission")SysUserPermission permission);
	
	public int checkUserPermission(@Param("permission")SysUserPermission permission);
}
