/*
 * package com.ntpc.finance.crm.security.rigistrationcontroller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import com.ntpc.finance.crm.security.registration.model.UserRegistration;
 * import
 * com.ntpc.finance.crm.security.registrationservice.UserRegistrationService;
 * 
 * @Controller
 * 
 * public class UserRegistrationController {
 * 
 * @Autowired private UserRegistrationService userRegistrationService;
 * 
 * public UserRegistrationController(UserRegistrationService
 * theUserRegistrationService){
 * userRegistrationService=theUserRegistrationService; }
 * 
 * @GetMapping("/dashboard") public String ShowRegistationList(Model model) {
 * List<UserRegistration>list=userRegistrationService.finalAll();
 * model.addAttribute("resistrationlist",list) ; return "dashboard";
 * 
 * }
 * 
 * 
 * @GetMapping("/showResistration") public String showFormForAdd(Model model) {
 * UserRegistration theUserRegistration=new UserRegistration();
 * model.addAttribute("resistrationlist",theUserRegistration); return
 * "resistration";
 * 
 * }
 * 
 * @PostMapping("/saveResistration") public String
 * showFormforSave(@ModelAttribute("resistrationlist") UserRegistration
 * theRegistration){
 * 
 * userRegistrationService.save(theRegistration); return "redirect:/dashboard";
 * 
 * }
 * 
 * }
 */