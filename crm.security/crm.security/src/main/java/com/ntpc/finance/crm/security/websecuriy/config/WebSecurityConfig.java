package com.ntpc.finance.crm.security.websecuriy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ntpc.finance.crm.security.userdetails.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {

		return new MyUserDetailsService();

	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(bCryptPasswordEncoder());
		authProvider.setUserDetailsService(userDetailsService());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	

		http.csrf().disable().authorizeRequests()
			.antMatchers("/","/aboutus", "/showResistration","/saveResistration").permitAll()
			.antMatchers("/user/dashboard").hasAnyAuthority("USER","ADMIN")
			.antMatchers("/user/manage").hasAuthority("ADMIN")
			.anyRequest().authenticated() .and() .formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/user/dashboard").failureUrl("/loginFailed").permitAll()
			.successForwardUrl("/postLogin").and().logout().logoutUrl("/logout")
			.logoutSuccessUrl("/postLogin").permitAll();

		
		
		
		/*
		 * http.csrf().disable() .authorizeRequests(). anyRequest()
		 * .authenticated().and() .formLogin().loginPage("/login").permitAll() .and()
		 * .logout() .permitAll() .permitAll();
		 */

		/*
		 * http.authorizeRequests()
		 * .antMatchers("/","/aboutus","/register/showResistration").permitAll()
		 * .anyRequest().authenticated() .and() .formLogin()
		 * .loginPage("/gateway/login") .loginProcessingUrl("/doLogin")
		 * .defaultSuccessUrl("/user/dashboard")
		 * .successForwardUrl("/gateway/postLogin") .failureUrl("/loginFailed")
		 * .permitAll() .and() .logout().invalidateHttpSession(true)
		 * .clearAuthentication(true).logoutRequestMatcher(new
		 * AntPathRequestMatcher("/logout"))
		 * .logoutSuccessUrl("/logout-Success").permitAll();
		 * 
		 */
	}

}