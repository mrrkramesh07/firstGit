package com.sonata.employee.servicelist.spring.crude.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sonata.employee.servicelist.spring.crude.demo.entity.Employee;
import com.sonata.employee.servicelist.spring.crude.demo.service.EmployeeServiceDao;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeServiceDao employeeServiceDao;

	@Autowired
	public EmployeeController(EmployeeServiceDao theemployeeServiceDao) {
		employeeServiceDao = theemployeeServiceDao;
	}

	@GetMapping("/list")
	public String EmployeeList(Model model,@RequestParam(value="page",required=false)Integer p) {
		int perPage=1;
		int page=(p!=null)?p:0;
Pageable pageable=PageRequest.of(page, perPage);


		Page<Employee> theemployee = employeeServiceDao.findAll(pageable);

		model.addAttribute("employees", theemployee);
		
		   long count = employeeServiceDao.count();
		   
	        double pageCount = Math.ceil((double)count / (double)perPage);

	        model.addAttribute("pageCount", (int)pageCount);
	        model.addAttribute("perPage", perPage);
	        model.addAttribute("count", count);
	        model.addAttribute("page", page);
	        
		return "employee/employee-home-page";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee theEmployee = new Employee();
		model.addAttribute("designemployee", theEmployee);
		return "employee/employee-form";

	}

	@PostMapping("/showEmployeeSave")
	public String showEmployeeSave(@ModelAttribute("designemployee") Employee theEployee) {

		employeeServiceDao.save(theEployee);
		return "redirect:/employee/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {
		Employee theemployee = employeeServiceDao.findById(theId);
		model.addAttribute("designemployee", theemployee);
		return "employee/employee-form";

	}

	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("employeeId") int theId) {
		employeeServiceDao.deleteById(theId);

		return "redirect:/employee/list";

	}
	
}
