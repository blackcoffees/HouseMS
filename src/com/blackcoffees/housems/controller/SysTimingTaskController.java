package com.blackcoffees.housems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackcoffees.housems.service.ISysTimingTaskService;

@Controller
@RequestMapping("sysTimingTask")
public class SysTimingTaskController {
	
	@Autowired
	private ISysTimingTaskService service;
}
