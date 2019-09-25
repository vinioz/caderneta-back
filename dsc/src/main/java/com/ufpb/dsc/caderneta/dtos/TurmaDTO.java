package com.ufpb.dsc.caderneta.dtos;

public class TurmaDTO {

	
	private String description;
	
	private boolean status_error_t;
	
	private String codigo;
	
	private Integer professor_id;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
	
	public TurmaDTO() {
		
	}
	
	
	public TurmaDTO(String description , String codigo, boolean status, Integer professor_id) {
		setDescription(description);
		setCodigo(codigo);
		setStatus_error_t(status);
		setProfessor_id(professor_id);
	}
}

