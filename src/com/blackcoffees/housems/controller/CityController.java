package com.blackcoffees.housems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackcoffees.housems.service.ICityService;

@Controller
@RequestMapping("city")
public class CityController {

	@Autowired
	private ICityService service;
}
