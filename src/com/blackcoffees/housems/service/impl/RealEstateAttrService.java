package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.RealEstateAttrMapper;
import com.blackcoffees.housems.service.IRealEstateAttrService;

@Service("realEstateAttrService")
public class RealEstateAttrService implements IRealEstateAttrService{
	
	@Autowired
	private RealEstateAttrMapper mapper;
}
