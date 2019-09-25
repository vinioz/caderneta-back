package com.ufpb.dsc.caderneta.dtos;

public class CursoDTO {

	
	private String nome;
	
	private boolean status_error_t;
	
	private String codigo;

	private Integer professor_id;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String description) {
		this.nome = description;
	}

	public boolean isStatus_error_t() {
		return status_error_t;
	}

	public void setStatus_error_t(boolean status_error_t) {
		this.status_error_t = status_error_t;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(Integer professor_id) {
		this.professor_id = professor_id;
	}
	
	
	
	public CursoDTO() {
		
	}
	
	
	public CursoDTO(String nome , String codigo, boolean status, Integer professor_id) {
		setNome(nome);
		setCodigo(codigo);
		setStatus_error_t(status);
		setProfessor_id(professor_id);
	}
}
