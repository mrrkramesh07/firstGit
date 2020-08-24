package com.ntpc.finance.crm.security.registrationservice;

import java.util.List;

import com.ntpc.finance.crm.security.registration.model.UserRegistration;


public interface UserRegistrationService {



	List<UserRegistration> finalAll();

	void save(UserRegistration theRegistration);

	

	
}
