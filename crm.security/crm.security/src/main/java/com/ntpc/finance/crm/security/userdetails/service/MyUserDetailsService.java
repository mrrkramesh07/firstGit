package com.ntpc.finance.crm.security.userdetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ntpc.finance.crm.security.dao.repository.UserDaoRepository;
import com.ntpc.finance.crm.security.user.modelentity.UsersModel;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDaoRepository userDaoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersModel users=userDaoRepository.getUserByUsernmae(username);
		if(users==null) {
			throw new UsernameNotFoundException("invalid");
		}
		
		return new MyUserDetailsServiceImpl(users);
		
	}
		
}
