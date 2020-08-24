package com.sonata.employee.servicelist.spring.crude.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

@GetMapping("/")	
public String ViewHomeController() {
	return "employee/home";
	
}


@GetMapping("/employee/homerelatednews")
public String showhomerelatednews() {
	return "employee/homenews";
	
}
	
}
