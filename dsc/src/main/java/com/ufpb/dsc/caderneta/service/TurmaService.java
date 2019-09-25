package com.ufpb.dsc.caderneta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufpb.dsc.caderneta.model.Turma;
import com.ufpb.dsc.caderneta.repository.TurmaRepository;

@Service
public class TurmaService {
	
	
	
	private TurmaRepository turmaRepository;
	
	
	@Autowired
	public TurmaService(TurmaRepository turmaRepository) {
		this.turmaRepository=turmaRepository;
		
		
	}
	
	
	
	public Turma addTurma(Turma turma) {
		return this.turmaRepository.save(turma);
	}
	
	
	
	public boolean addTurma(String codigo,String nome, Integer quant_alunos,String creat_at) {
		try {
			
			if(this.turmaRepository.checkIfTurmaExistByCod(codigo) == null) {
				this.turmaRepository.addTurma(codigo, creat_at, quant_alunos,nome);
				return true;
			}else {
				if(this.turmaRepository.getTurmas().size() == 0) {
					this.turmaRepository.addTurma(codigo, creat_at, quant_alunos,nome);
					return true;
				}
				
				return false;
			}
		
		}catch(NullPointerException e) {
			return false;
		}
	}

	
	/**
	 * EDDDT
	 * @param codigo
	 * @param nome
	 * @param quant_alunos
	 * @return
	 */
	
	public Integer edtTurma(String codigo,String nome, Integer quant_alunos) {
		if(checkTurmaByCodigo(codigo) != null){
			return this.turmaRepository.editTurma(codigo,nome, quant_alunos);
		}else {
			return 0;
		}
	}
	
	
	public Turma checkTurmaByCodigo(String codigo) {
		try {
			return this.turmaRepository.checkIfTurmaExistByCod(codigo);
		}catch(NullPointerException e) {
			return null;
		}
	}
	
	
	public List<Turma> getTurmas(){
		try {
			return this.turmaRepository.getTurmas();
		}catch(NullPointerException e) {
			return null;
		}
	}
	
	
	public void removeTurma(Turma turma) {
		this.turmaRepository.delete(turma);
	}
}
