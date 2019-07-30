package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.WebRegionMapper;
import com.blackcoffees.housems.service.IWebRegionService;

@Service("webRegionService")
public class WebRegionService implements IWebRegionService{

	@Autowired
	private WebRegionMapper mapper;
}
