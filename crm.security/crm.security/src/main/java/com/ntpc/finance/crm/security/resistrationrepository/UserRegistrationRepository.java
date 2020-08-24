package com.ntpc.finance.crm.security.resistrationrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntpc.finance.crm.security.registration.model.UserRegistration;


public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {

}
