package com.ufpb.dsc.caderneta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Professor extends Aluno{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	public Professor() {}
	public Professor(String nome,String codigo,String cpf, String responsavel,String contato,String endereco,String data,String email,String creat_at) {
		super(nome,codigo,cpf,responsavel,contato,endereco,data,email,creat_at);
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}
}