package com.ntpc.finance.crm.security.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestParam;

import com.ntpc.finance.crm.security.user.modelentity.UsersModel;

public interface UserDaoRepository extends JpaRepository<UsersModel, Long> {
	
	
	@Query("select u from UsersModel u where u.username=:username")
	public UsersModel getUserByUsernmae(@RequestParam("username")String username);

}
