package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.WebSourceMapper;
import com.blackcoffees.housems.service.IWebSourceService;

@Service("webSourceService")
public class WebSourceService implements IWebSourceService{

	@Autowired
	private WebSourceMapper mapper;
}
