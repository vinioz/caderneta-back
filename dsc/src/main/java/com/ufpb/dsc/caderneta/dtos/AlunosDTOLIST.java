package com.ufpb.dsc.caderneta.dtos;


import java.util.List;

import com.ufpb.dsc.caderneta.model.Alunos;

public class AlunosDTOLIST {

	
	
	private Integer quantity;

	private List<Alunos> list_alunos;
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<Alunos> getList_alunos() {
		return list_alunos;
	}

	public void setList_alunos(List<Alunos> list_alunos) {
		this.list_alunos = list_alunos;
	}
	
	
	public AlunosDTOLIST(Integer quantity, List<Alunos> list) {
		setQuantity(quantity);
		setList_alunos(list);
	
	}
}
