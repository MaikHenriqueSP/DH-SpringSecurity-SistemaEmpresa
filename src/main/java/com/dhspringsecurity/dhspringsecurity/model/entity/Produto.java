package com.dhspringsecurity.dhspringsecurity.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id
	private Integer idProduto;
	private String nome;	
		
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
