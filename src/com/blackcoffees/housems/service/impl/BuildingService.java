package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.BuildingMapper;
import com.blackcoffees.housems.service.IBuildingService;

@Service("buildingService")
public class BuildingService implements IBuildingService{

	@Autowired
	private BuildingMapper mapper;
}
