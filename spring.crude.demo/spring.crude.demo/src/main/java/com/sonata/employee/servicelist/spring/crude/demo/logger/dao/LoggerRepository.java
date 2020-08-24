package com.sonata.employee.servicelist.spring.crude.demo.logger.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonata.employee.servicelist.spring.crude.demo.logger.entity.LoggerModel;

public interface LoggerRepository extends JpaRepository <LoggerModel,Integer> {

}
