package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.RegionMapper;
import com.blackcoffees.housems.service.IRegionService;

@Service("regionService")
public class RegionService implements IRegionService{

	@Autowired
	private RegionMapper mapper;
}
