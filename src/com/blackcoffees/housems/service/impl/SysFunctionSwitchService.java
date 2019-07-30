package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.SysFunctionSwitchMapper;
import com.blackcoffees.housems.service.ISysFunctoinSwitchService;

@Service("sysFunctionSwitchService")
public class SysFunctionSwitchService implements ISysFunctoinSwitchService{

	@Autowired
	private SysFunctionSwitchMapper mapper;
}
