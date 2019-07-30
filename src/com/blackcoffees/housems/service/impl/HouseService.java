package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.HouseMapper;
import com.blackcoffees.housems.service.IHouseService;

@Service("houseService")
public class HouseService implements IHouseService{

	@Autowired
	private HouseMapper mapper;
}
