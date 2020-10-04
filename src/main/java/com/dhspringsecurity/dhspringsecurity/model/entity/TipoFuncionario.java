package com.dhspringsecurity.dhspringsecurity.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoFuncionario {

	@Id
	private Integer idTipoFuncionario;
	private String tipoFuncionario;
	private Integer idFuncionario;
	
		
	public TipoFuncionario() {
	}
	
	
	
	public TipoFuncionario(Integer idTipoFuncionario, String tipoFuncionario, Integer idFuncionario) {

		this.idTipoFuncionario = idTipoFuncionario;
		this.tipoFuncionario = tipoFuncionario;
		this.idFuncionario = idFuncionario;
	}



	public Integer getIdTipoFuncionario() {
		return idTipoFuncionario;
	}
	public void setIdTipoFuncionario(Integer idTipoFuncionario) {
		this.idTipoFuncionario = idTipoFuncionario;
	}
	public String getTipoFuncionario() {
		return tipoFuncionario;
	}
	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	
}
