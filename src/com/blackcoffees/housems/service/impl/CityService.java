package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.CityMapper;
import com.blackcoffees.housems.service.ICityService;

@Service("cityService")
public class CityService implements ICityService{

	@Autowired
	private CityMapper mapper;
}
