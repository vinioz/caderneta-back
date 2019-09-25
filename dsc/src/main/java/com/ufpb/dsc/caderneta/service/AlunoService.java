package com.ufpb.dsc.caderneta.service;
import java.util.List;

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
				if(this.alunosRepository.checkIfAlunoExist(cpf) == null) {
					this.alunosRepository.addAluno(cpf, cpfResponsavel, nome, dataNascimento,responsavel);			
					return true;
				}else {
					if(this.alunosRepository.getAlunos().size() == 0 ) {
						this.alunosRepository.addAluno(cpf, cpfResponsavel, nome, dataNascimento,responsavel);
						return true;
					}
					
					return false;
				}
		}catch(NullPointerException e) {
			return false;
		}
		
	}
	
	/**
	 * verifica se um aluno existe pelo cpf
	 * @param cpf
	 * @return boolean
	 */
	public boolean checkAlunoByCpf(String cpf) {
		try {
		if(this.alunosRepository.checkIfAlunoExist(cpf) == null) {
			return false;
		}
		return true;
		}catch(NullPointerException e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @param cpf
	 * @param cpfResponsavel
	 * @param nome
	 * @param dataNascimento
	 * @param responsavel
	 * @return
	 */
	public Integer editAluno(String cpf, String cpfResponsavel , String nome , String dataNascimento , String responsavel) {
		return this.alunosRepository.editAluno(nome, cpfResponsavel, dataNascimento, responsavel, cpf);
		
	}
	
	
	
	public Alunos getAlunoByCpf(String cpf) {
		try {
			return this.alunosRepository.getAlunosByCpf(cpf);
		}catch(NullPointerException e) {
			return null;
		}
	}
	/**
	 * remove;
	 * @param aluno
	 */
	public void removeAluno(Alunos aluno) {
		this.alunosRepository.delete(aluno);
	}
	
	public List<Alunos> getAllAlunos(){
		try {
			return this.alunosRepository.getAllAlunos();
		}catch(NullPointerException e) {
			return null;
		}
	}
	
	
}
