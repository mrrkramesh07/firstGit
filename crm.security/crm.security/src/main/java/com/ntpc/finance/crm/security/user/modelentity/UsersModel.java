package com.ntpc.finance.crm.security.user.modelentity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UsersModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="enabled")
	private boolean enabled;
	

	
	public UsersModel() {
		
	}


	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable( name="users_roles",
			
joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
	
	
	
	
	private Set<RolesModel> roles=new HashSet<>();
	
	public Set<RolesModel> getRoles() {
		return roles;
	}



	public void setRoles(Set<RolesModel> roles) {
		this.roles = roles;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	
	public String getFullName() {
		return fullname;
		
	}
	
	public void setFullName(String fullname) {
		this.fullname=fullname;
	}
	
	

	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	@Override
	public String toString() {
		return "UserModel [user_id=" + user_id + ", username=" + username + ", password=" + password + ", fullname="+fullname+", enabled="
				+ enabled + "]";
	}
	
	
	
}
