package com.dhspringsecurity.dhspringsecurity.model.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario {
	@Id
	private Integer idFuncionario;
	private String nome;
	private String email;
	private LocalTime pontoEntrada;
	private LocalTime pontoSaida;
	private double salario;
	
		
	public Funcionario() {

	}
	
	
	public Funcionario(Integer idFuncionario, String nome, String email, LocalTime pontoEntrada, LocalTime pontoSaida,
			double salario) {
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.email = email;
		this.pontoEntrada = pontoEntrada;
		this.pontoSaida = pontoSaida;
		this.salario = salario;
	}


	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalTime getPontoEntrada() {
		return pontoEntrada;
	}
	public void setPontoEntrada(LocalTime pontoEntrada) {
		this.pontoEntrada = pontoEntrada;
	}
	public LocalTime getPontoSaida() {
		return pontoSaida;
	}
	public void setPontoSaida(LocalTime pontoSaida) {
		this.pontoSaida = pontoSaida;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	

}
