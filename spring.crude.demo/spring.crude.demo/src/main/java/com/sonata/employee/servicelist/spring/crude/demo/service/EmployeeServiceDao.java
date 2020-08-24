package com.sonata.employee.servicelist.spring.crude.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import com.sonata.employee.servicelist.spring.crude.demo.entity.Employee;

public interface EmployeeServiceDao {

public Page<Employee> findAll(Pageable pageable);

public void save(Employee theEployee);

public Employee findById(int theId);

public void deleteById(int theId);

public long count();











}
