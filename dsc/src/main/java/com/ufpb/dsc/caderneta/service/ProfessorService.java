package com.ufpb.dsc.caderneta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufpb.dsc.caderneta.model.Professor;
import com.ufpb.dsc.caderneta.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	private ProfessorRepository professorRepositorh;
	
	@Autowired 
	private ProfessorService (ProfessorRepository professorRepositorh) {
		this.professorRepositorh = professorRepositorh;
	}
	
	
	
	public Professor addProfessor (Professor professor) {
		return this.professorRepositorh.save(professor);
	}
	
	
	public boolean addProfessor(String cpf, String nome, String codturma) {
		return false;
	}
	
	

}
