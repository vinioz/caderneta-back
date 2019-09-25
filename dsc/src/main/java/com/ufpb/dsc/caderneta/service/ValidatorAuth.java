package com.ufpb.dsc.caderneta.service;

import com.ufpb.dsc.caderneta.model.Alunos;
import com.ufpb.dsc.caderneta.model.Professor;


/**
 * 
 * @author osvaldoairon
 *
 */
public interface ValidatorAuth {
	
	
	
	/**
	 * verifica se o username/password não é nulo por exemplo.
	 * @param username
	 * @param password
	 * @return
	 */
	boolean checkCredentials(String username,String password);
	
	/**
	 * Permite criar uma nova conta admite o aluno como user;
	 * @param username
	 * @param password
	 * @param aluno
	 */
	void createAccount(String username,String password, Alunos aluno);
	

	/**
	 * permite criar uma nova conta admite o professor como user;
	 * @param username
	 * @param password
	 * @param professor
	 */
	void createAccount(String username,String password, Professor professor);
	
	
	/**
	 * verifica se o username ja existe. Username é identificador unico de cada user;
	 * @param username
	 * @return
	 */
	boolean checkIfAccountExist(String username);
	
	
}
