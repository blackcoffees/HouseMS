package com.blackcoffees.housems.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blackcoffees.housems.db.entity.SysUser;
import com.blackcoffees.housems.util.Pager;

public interface SysUserMapper {
	public int userLogin(@Param("user") SysUser user);
	
	public int updateUserLastLogin(@Param("user")SysUser user);
	
	public SysUser getUserByUsername(@Param("username")String username);
	
	public List<SysUser> getAllUser(@Param("pager")Pager pager);
	
	public int addUser(@Param("user")SysUser user);
	
	public int updateUserStatus(@Param("user")SysUser user);
	
	public int updateResetPassword(@Param("user")SysUser user);
}
