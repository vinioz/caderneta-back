package com.ufpb.dsc.caderneta.dtos;

import java.util.List;

import com.ufpb.dsc.caderneta.model.Curso;
import com.ufpb.dsc.caderneta.model.Turma;

public class TurmaDTOLIST {
	
	
	private Integer quantity;
	
	private List<Turma> list_turma;
	
	private List<Curso> list_cursos;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<Turma> getList_turma() {
		return list_turma;
	}

	public void setList_turma(List<Turma> list_turma) {
		this.list_turma = list_turma;
	}
	
	
	public TurmaDTOLIST(Integer quantity, List<Turma> turmas) {
		setQuantity(quantity);
		setList_turma(turmas);
	}

	public TurmaDTOLIST() {}
	

	public List<Curso> getList_cursos() {
		return list_cursos;
	}

	public void setList_cursos(List<Curso> list_cursos) {
		this.list_cursos = list_cursos;
	}
	


}
