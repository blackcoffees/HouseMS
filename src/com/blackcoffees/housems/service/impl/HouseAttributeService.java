package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.HouseAttributeMapper;
import com.blackcoffees.housems.service.IHouseAttributeService;

@Service("houseAttributeService")
public class HouseAttributeService implements IHouseAttributeService{
	
	@Autowired
	private HouseAttributeMapper mapper;

}
