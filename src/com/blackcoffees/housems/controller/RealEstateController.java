package com.blackcoffees.housems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackcoffees.housems.service.IRealEstateService;

@Controller
@RequestMapping("realEstate")
public class RealEstateController {
	
	@Autowired
	private IRealEstateService service;
}
