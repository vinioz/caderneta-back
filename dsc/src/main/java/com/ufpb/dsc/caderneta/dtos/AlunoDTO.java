package com.ufpb.dsc.caderneta.dtos;

public class AlunoDTO {

	private String description;
	
	private boolean status_error;
	
	private String detail;

	public boolean isStatus_error() {
		return status_error;
	}

	public void setStatus_error(boolean status_error) {
		this.status_error = status_error;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public AlunoDTO(String description, boolean status_error, String detail) {
		setStatus_error(status_error);
		setDescription(description);
		setDetail(detail);
	}
	public AlunoDTO(String description) {
		setDescription(description);
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
