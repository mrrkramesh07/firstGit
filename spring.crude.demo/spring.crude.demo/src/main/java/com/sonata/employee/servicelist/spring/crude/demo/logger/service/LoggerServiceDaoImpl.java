package com.sonata.employee.servicelist.spring.crude.demo.logger.service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonata.employee.servicelist.spring.crude.demo.entity.Employee;
import com.sonata.employee.servicelist.spring.crude.demo.logger.dao.LoggerRepository;
import com.sonata.employee.servicelist.spring.crude.demo.logger.entity.LoggerModel;
@Service
public class LoggerServiceDaoImpl implements LoggerServiceDao {
	
	private LoggerRepository loggerRepository;

	@Autowired
	public LoggerServiceDaoImpl(LoggerRepository theloggerRepository) {
		loggerRepository=theloggerRepository;
	}

	@Override
	public List<LoggerModel> findAll() {
	
		return loggerRepository.findAll();
	}

	@Override
	public void save(LoggerModel theLoggerModel) {
		loggerRepository.save(theLoggerModel);
		
	}

	

	@Override
	public void deleteById(int themodel) {
		loggerRepository.deleteById(themodel);
		
	}

	@Override
	public LoggerModel findById(int theId) {
		Optional<LoggerModel>result=loggerRepository.findById(theId);
		LoggerModel themodel=null;
		if(result.isPresent()) {
			themodel=result.get();
		}
		else {
			throw new RuntimeException("error"+theId);
		}
		return themodel;
	}


}