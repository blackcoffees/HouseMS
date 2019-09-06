package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.SysUserLoginLogMapper;
import com.blackcoffees.housems.db.entity.SysUserLoginLog;
import com.blackcoffees.housems.service.ISysUserLoginLogService;
import com.blackcoffees.housems.util.DateUtil;

@Service("sysUserLoginLogService")
public class SysUserLoginLogService implements ISysUserLoginLogService{

	@Autowired
	private SysUserLoginLogMapper mapper;

	@Override
	public int addLoginLog(SysUserLoginLog loginLog) {
		// TODO Auto-generated method stub
		loginLog.setCreated(DateUtil.getNow());
		return mapper.addLoginLog(loginLog);
	}

	@Override
	public SysUserLoginLog getLoginLog(String startTime) {
		// TODO Auto-generated method stub
		return mapper.getLoginLog(startTime);
	}
}
