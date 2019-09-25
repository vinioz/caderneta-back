package com.ufpb.dsc.caderneta.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ufpb.dsc.caderneta.service.UserDetailServiceImpl;

@Configuration
public class ConfigurationApp  extends WebSecurityConfigurerAdapter {


	private UserDetailServiceImpl userDetailServiceImpl;
	
	
	
	
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**").permitAll();
        
        httpSecurity.headers().frameOptions().disable();
    }
    
}
