package com.sonata.employee.servicelist.spring.crude.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sonata.employee.servicelist.spring.crude.demo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	Page<Employee>findAll(Pageable pageable);
}
