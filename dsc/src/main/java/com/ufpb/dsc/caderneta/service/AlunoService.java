package com.ufpb.dsc.caderneta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufpb.dsc.caderneta.model.Alunos;
import com.ufpb.dsc.caderneta.repository.AlunosRepository;

@Service
public class AlunoService {

	
	private AlunosRepository alunosRepository;

	
	@Autowired
	private AlunoService(AlunosRepository alunosRepository) {
		this.alunosRepository=alunosRepository;
		
	}
	
	
	public Alunos addAluno(Alunos aluno) {
		return this.alunosRepository.save(aluno);
	}
	
	public boolean addAluno(String nome , String cpfResponsavel , String cpf,String dataNascimento, String responsavel) {
		
		try {
		if(this.alunosRepository.checkIfAlunoExist(cpf) != null) {
			this.alunosRepository.addAluno(cpf, cpfResponsavel, nome, dataNascimento,responsavel);	
			return true;
		}else {
			return false;
		}
		}catch(NullPointerException e) {
			return false;
		}
		
	}
}
