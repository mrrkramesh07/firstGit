package com.ntpc.finance.crm.security.homecontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ntpc.finance.crm.security.registration.model.UserRegistration;
import com.ntpc.finance.crm.security.registrationservice.UserRegistrationService;
import com.ntpc.finance.crm.security.user.modelentity.UsersModel;

@Controller
public class GateWayController {

	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@GetMapping("/login")
	public String ShowLoginPage() {
		return "login";
		
	}
	
	@PostMapping("/postLogin")
    public String postLogin(Model model, HttpSession session) {
     
        // read principal out of security context and set it to session
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        validatePrinciple(authentication.getPrincipal());
        String loggedInUser = ((UserDetails) authentication.getPrincipal()).getUsername();
       
     
        return "redirect:/user/dashboard";
    }
	
	 private void validatePrinciple(Object principal) {
	        if (!(principal instanceof UserDetails)) {
	            throw new  IllegalArgumentException("Principal can not be null!");
	        }
	    }
	 
	 
	 
	 
	
	public GateWayController(UserRegistrationService theUserRegistrationService){
		userRegistrationService=theUserRegistrationService;
	}
	
	 @GetMapping("/user/dashboard") public String ShowRegistationList(Model model) {
		  List<UserRegistration>list=userRegistrationService.finalAll();
		  model.addAttribute("resistrationlist",list) ;
		  return "dashboard";
		  
		 }
	

	
	
	@GetMapping("/showResistration")
	public String showFormForAdd(Model model) {
		UserRegistration theUserRegistration=new UserRegistration();
		model.addAttribute("resistrationlist",theUserRegistration);
		return "resistration";
		
	}
	@PostMapping("/saveResistration")
	public String showFormforSave(@ModelAttribute("resistrationlist") UserRegistration theRegistration){
		
		userRegistrationService.save(theRegistration);
		return "redirect:/dashboard";
		
	}
	
}
