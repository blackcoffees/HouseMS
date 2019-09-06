package com.blackcoffees.housems.db.dao;

import org.apache.ibatis.annotations.Param;

import com.blackcoffees.housems.db.entity.SysUserLoginLog;

public interface SysUserLoginLogMapper {
	public int addLoginLog(@Param("loginLog")SysUserLoginLog loginLog);
	
	public SysUserLoginLog getLoginLog(@Param("startTime")String startTime);
}
