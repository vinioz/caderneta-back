package com.ufpb.dsc.caderneta.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;

	private String codigo;

	private String creat_at;

	private Integer quantidade_alunos;
	
	
	public Integer getQuantidade_alunos() {
		return quantidade_alunos;
	}

	public void setQuantidade_alunos(Integer quantidade_alunos) {
		this.quantidade_alunos = quantidade_alunos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Turma() {

	}

	
	@ManyToMany
	@JoinTable(name="turma_curso", joinColumns= {@JoinColumn(name="turma_Id", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="curso_id", referencedColumnName="id")})
	private List<Curso> cursos_turmas;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCreat_at() {
		return creat_at;
	}

	public void setCreat_at(String creat_at) {
		this.creat_at = creat_at;
	}

}
