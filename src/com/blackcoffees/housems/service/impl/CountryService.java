package com.blackcoffees.housems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.CountryMapper;
import com.blackcoffees.housems.service.ICountryService;

@Service("countryService")
public class CountryService implements ICountryService{

	@Autowired
	private CountryMapper mapper;
}
