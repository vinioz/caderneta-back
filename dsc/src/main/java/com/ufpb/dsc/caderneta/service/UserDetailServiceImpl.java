package com.ufpb.dsc.caderneta.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ufpb.dsc.caderneta.repository.AlunosRepository;
import com.ufpb.dsc.caderneta.repository.ProfessorRepository;




/**
 * 
 * @author osvaldoairon
 *
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	

	
	
	@Autowired
	public UserDetailServiceImpl( ) {
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	
	}

	
	
	
}
