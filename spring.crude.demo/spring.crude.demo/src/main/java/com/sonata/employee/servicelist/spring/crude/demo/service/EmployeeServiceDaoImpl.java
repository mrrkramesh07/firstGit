package com.sonata.employee.servicelist.spring.crude.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sonata.employee.servicelist.spring.crude.demo.dao.EmployeeRepository;
import com.sonata.employee.servicelist.spring.crude.demo.entity.Employee;

@Service
public class EmployeeServiceDaoImpl implements EmployeeServiceDao {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceDaoImpl(EmployeeRepository theemployeeRepository) {
		employeeRepository = theemployeeRepository;
	}
	@Override
	public Page<Employee> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(pageable);
	}
	

	@Override
	public void save(Employee theEployee) {
		employeeRepository.save(theEployee);

	}

	/* for update */
	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theEmployee;

	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return employeeRepository.count();
	}




}
