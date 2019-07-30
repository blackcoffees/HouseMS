package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.RealEstateMapper;
import com.blackcoffees.housems.service.IRealEstateService;

@Service("realEstateService")
public class RealEstateService implements IRealEstateService{

	@Autowired
	private RealEstateMapper mapper;
}
