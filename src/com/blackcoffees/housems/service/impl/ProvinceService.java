package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.ProvinceMapper;
import com.blackcoffees.housems.service.IProvinceService;

@Service("provinceService")
public class ProvinceService implements IProvinceService{

	@Autowired
	private ProvinceMapper mapper;
}
