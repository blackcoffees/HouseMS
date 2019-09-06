package com.blackcoffees.housems.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.blackcoffees.housems.db.entity.SysUser;
import com.blackcoffees.housems.util.Pager;

public interface ISysUserService {
	public SysUser userLogin(SysUser user);
	
	public int updateUserLastLogin(SysUser user);
	
	public SysUser getUserByUsername(String username);
	
	public List<SysUser> getAllUser(Pager pager);
	
	public Map<String, Object> addUser(SysUser user);
	
	public int updateUserStatus(SysUser user);
	
	public int updateResetPassword(SysUser user);
}
