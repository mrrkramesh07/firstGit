package com.ntpc.finance.crm.security.homecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserContoller {

	@RequestMapping("/user/dashboard")
	public String Dashboard() {

	
		return "dashboard";

	}

	@GetMapping("/user/manage")
	public String Managed() {
		return "dashboard";

	}

	@GetMapping("/postLogin")
	public String Logout() {
		return "redirect:/login";
	}

}
