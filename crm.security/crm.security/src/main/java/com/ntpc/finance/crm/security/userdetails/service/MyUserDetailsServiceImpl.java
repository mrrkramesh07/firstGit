package com.ntpc.finance.crm.security.userdetails.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ntpc.finance.crm.security.user.modelentity.RolesModel;
import com.ntpc.finance.crm.security.user.modelentity.UsersModel;

public class MyUserDetailsServiceImpl implements UserDetails {

	@Autowired
	private UsersModel user;

	public MyUserDetailsServiceImpl(UsersModel user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<RolesModel> roles = user.getRoles();
		List<SimpleGrantedAuthority> athority = new ArrayList();

		for (RolesModel role : roles) {
			athority.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		return athority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	 public String getFullname() { // TODO Auto-generated method stub return
		  return user.getFullName(); }
	 
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isEnabled();
	}

}
