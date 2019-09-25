package com.ufpb.dsc.caderneta.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufpb.dsc.caderneta.model.Alunos;
import com.ufpb.dsc.caderneta.model.Professor;
import com.ufpb.dsc.caderneta.repository.AlunosRepository;
import com.ufpb.dsc.caderneta.repository.ProfessorRepository;


/**
 * 
 * @author osvaldoairon
 *
 */
@Service
public class AuthenticationService implements ValidatorAuth{
	
	
	private AlunosRepository alunosRepository;
	
	private ProfessorRepository professorRepository;
	
	
	@Autowired
	public AuthenticationService(AlunosRepository alunoRepository, ProfessorRepository professorRepository) {
		this.alunosRepository=alunoRepository;
		this.professorRepository = professorRepository;
	}


	
	@Override
	public boolean checkCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void createAccount(String username, String password, Alunos aluno) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createAccount(String username, String password, Professor professor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean checkIfAccountExist(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
