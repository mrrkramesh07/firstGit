package com.sonata.employee.servicelist.spring.crude.demo.logger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sonata.employee.servicelist.spring.crude.demo.logger.entity.LoggerModel;
import com.sonata.employee.servicelist.spring.crude.demo.logger.service.LoggerServiceDao;

@Controller
@RequestMapping("/logging")
public class LoggerController {
	@Autowired
	private LoggerServiceDao loggerServiceDao;
	
	@Autowired
	public LoggerController(LoggerServiceDao theloggerServiceDao) {
		loggerServiceDao=theloggerServiceDao;
		
	}
	
	@GetMapping("/list")
	public String showList(Model model) {
		List<LoggerModel> theLoggerModel=loggerServiceDao.findAll();
		model.addAttribute("loggers", theLoggerModel);
		
		return "logging/logger-home-page";
		
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		LoggerModel theLoggerModel=new LoggerModel();
		model.addAttribute("loggers", theLoggerModel);
		
		return "logging/logger-form-page";
		
	}
	
	@PostMapping("/showFormForSave")
	public String showFormForSave(@ModelAttribute("loggers") LoggerModel theLoggerModel) {
		loggerServiceDao.save(theLoggerModel);
		return "redirect:/logging/list";
		
	}
	
@GetMapping("/showFormForUpdate")
public String showFormForUpdate(@RequestParam("loggerId")int theId,Model model) {
	LoggerModel theLoggerModel=loggerServiceDao.findById(theId);
	
	model.addAttribute("loggers", theLoggerModel);
	
	return "logging/logger-form-page";
	
}

@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("loggerId") int themodel) {
	
	loggerServiceDao.deleteById(themodel);
		return "redirect:/logging/list";
	
}
		
	

}
