package com.blackcoffees.housems.service;

import com.blackcoffees.housems.db.entity.SysUserLoginLog;

public interface ISysUserLoginLogService {
	public int addLoginLog(SysUserLoginLog loginLog);
	
	public SysUserLoginLog getLoginLog(String startTime);
}
