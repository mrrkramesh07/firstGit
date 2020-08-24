package com.ntpc.finance.crm.security.homecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
	
	
	@GetMapping("/")
	public String MainHomeController () {
			      return "home";

	}
	
	@GetMapping("/aboutus")
	public String AboutUs() {
		return "aboutus";
		
	}

		
}
