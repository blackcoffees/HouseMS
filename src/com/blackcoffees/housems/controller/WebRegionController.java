package com.blackcoffees.housems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackcoffees.housems.service.IWebRegionService;

@Controller
@RequestMapping("webRegion")
public class WebRegionController {
	
	@Autowired
	private IWebRegionService service;
}
