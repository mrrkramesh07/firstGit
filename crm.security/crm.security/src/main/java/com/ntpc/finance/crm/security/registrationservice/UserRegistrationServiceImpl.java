package com.ntpc.finance.crm.security.registrationservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ntpc.finance.crm.security.registration.model.UserRegistration;
import com.ntpc.finance.crm.security.resistrationrepository.UserRegistrationRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	

	@Autowired
	private UserRegistrationRepository userRegistrationRepository;
	
	public UserRegistrationServiceImpl(UserRegistrationRepository theUserRegistrationRepository) {
		userRegistrationRepository=theUserRegistrationRepository;
	}

	@Override
	public List<UserRegistration> finalAll() {
		// TODO Auto-generated method stub
		return userRegistrationRepository.findAll();
	}

	@Override
	public void save(UserRegistration theRegistration) {
		
		theRegistration.setPassword(encoder.encode(theRegistration.getPassword()));
		userRegistrationRepository.save(theRegistration);	
		
	}

	
}
