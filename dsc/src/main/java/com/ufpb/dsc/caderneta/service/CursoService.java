package com.ufpb.dsc.caderneta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufpb.dsc.caderneta.model.Curso;
import com.ufpb.dsc.caderneta.repository.CursoRepository;

@Service
public class CursoService {
	
	
	
	private CursoRepository cursoRepository;
	
	
	@Autowired
	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository=cursoRepository;
		
		
	}
	
	
	
	public Curso addCurso(Curso curso) {
		return this.cursoRepository.save(curso);
	}
	
	
	
	public boolean addCurso(String codigo,String nome, Integer quant_alunos,String creat_at) {
		try {
			
			if(this.cursoRepository.checkIfCursoExistByCod(codigo) == null) {
				this.cursoRepository.addCurso(codigo, creat_at, quant_alunos,nome);
				return true;
			}else {
				if(this.cursoRepository.getCurso().size() == 0) {
					this.cursoRepository.addCurso(codigo, creat_at, quant_alunos,nome);
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
	
	public Integer edtCurso(String codigo,String nome, Integer quant_alunos) {
		if(checkCursoByCodigo(codigo) != null){
			return this.cursoRepository.editCurso(codigo,nome, quant_alunos);
		}else {
			return 0;
		}
	}
	
	
	private Object checkCursoByCodigo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}



	public Curso checkTurmaByCodigo(String codigo) {
		try {
			return this.cursoRepository.checkIfCursoExistByCod(codigo);
		}catch(NullPointerException e) {
			return null;
		}
	}
	
	
	public List<Curso> getCurso(){
		try {
			return this.cursoRepository.getCurso();
		}catch(NullPointerException e) {
			return null;
		}
	}
	
	
	public void removeCurso(Curso curso) {
		this.cursoRepository.delete(curso);
	}
}
