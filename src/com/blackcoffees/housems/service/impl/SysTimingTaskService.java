package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.SysTimingTaskMapper;
import com.blackcoffees.housems.service.ISysTimingTaskService;

@Service("sysTimingTaskService")
public class SysTimingTaskService implements ISysTimingTaskService{

	@Autowired
	private SysTimingTaskMapper mapper;
}
