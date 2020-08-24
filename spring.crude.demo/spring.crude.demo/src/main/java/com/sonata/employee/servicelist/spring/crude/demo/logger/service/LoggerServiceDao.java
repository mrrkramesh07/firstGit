package com.sonata.employee.servicelist.spring.crude.demo.logger.service;

import java.util.List;

import com.sonata.employee.servicelist.spring.crude.demo.logger.entity.LoggerModel;


public interface LoggerServiceDao {

	public List<LoggerModel> findAll();

	public void save(LoggerModel theLoggerModel);

	public LoggerModel findById(int theId);

	public void deleteById(int themodel);

	

	

}
