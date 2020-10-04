package com.dhspringsecurity.dhspringsecurity.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autorizacao {

	@Id
	private String email;
	private String autoridade;
	
	public Autorizacao() {}
	
	public Autorizacao(String email, String autoridade) {
		this.email = email;
		this.autoridade = autoridade;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAutoridade() {
		return autoridade;
	}
	public void setAutoridade(String autoridade) {
		this.autoridade = autoridade;
	}
	
	
}
