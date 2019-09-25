package com.ufpb.dsc.caderneta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;

import java.util.List;


@Entity
public class Professor{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	private String cpf;
	private String nome;
	private String codturma;
	
	
	
	@ManyToMany
	@JoinTable(name="professor_turmas", joinColumns= {@JoinColumn(name="professor_id", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="turma_id", referencedColumnName="id")})
	private List<Turma> turma;
	
	
	public Professor() {}
	

	public int getId() {
		return this.id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public List<Alunos> getList_alunos() {
		return list_alunos;
	}


	public void setList_alunos(List<Alunos> list_alunos) {
		this.list_alunos = list_alunos;
	}



	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCodturma() {
		return codturma;
	}


	public void setCodturma(String codturma) {
		this.codturma = codturma;
	}



	@ManyToMany
	@JoinTable(name="professor_alunos", joinColumns= {@JoinColumn(name="professor_id", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="alunos_id", referencedColumnName="id")})
	private List<Alunos> list_alunos;

	
}