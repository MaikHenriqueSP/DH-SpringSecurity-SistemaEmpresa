package com.dhspringsecurity.dhspringsecurity.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dhspringsecurity.dhspringsecurity.model.entity.Autorizacao;
import com.dhspringsecurity.dhspringsecurity.model.entity.Funcionario;
import com.dhspringsecurity.dhspringsecurity.model.repository.AutorizacaoRepository;
import com.dhspringsecurity.dhspringsecurity.model.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private FuncionarioRepository funcionarioRepository;
	private AutorizacaoRepository autorizacaoRepository;
		
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository, AutorizacaoRepository autorizacaoRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.autorizacaoRepository = autorizacaoRepository;
	}

	public ResponseEntity<Object> cadastrarFuncionario(Funcionario funcionario) {
		if (funcionario == null) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar funcionario!");
		}
		funcionarioRepository.save(funcionario);
		Autorizacao autorizacao = new Autorizacao(funcionario.getEmail(), "ROLE_FUNCIONARIO");
		autorizacaoRepository.save(autorizacao);
		return ResponseEntity.ok("Funcionario cadastrado com sucesso!");
	}
	
	public ResponseEntity<Object> demitirFuncionario(Integer id){
		Optional<Funcionario> optFuncionario = funcionarioRepository.findById(id);
		if (optFuncionario.isEmpty()) {
			return ResponseEntity.badRequest().body("Funcionario não encontrado!");			
		}
		Funcionario funcionario = optFuncionario.get();
		funcionarioRepository.deleteById(id);
		autorizacaoRepository.deleteById(funcionario.getEmail());
		return ResponseEntity.ok("Funcionario demitido com sucesso!");
	}
	
	public ResponseEntity<Object> reajustarSalario(Integer id, double salario ){
		Optional<Funcionario> optFuncionario = funcionarioRepository.findById(id);
		if(optFuncionario.isEmpty()) {
			return ResponseEntity.badRequest().body("Erro ao reajustar salário do funcionario!");	
		}
		Funcionario funcionario =  optFuncionario.get();
		String cargo = autorizacaoRepository.findById(funcionario.getEmail()).get().getAutoridade();
		
		if (cargo.contains("GERENTE")) {
			return ResponseEntity.badRequest().body("Gerentes não podem ajustar salários de outros gerentes ou de si mesmo!");	
		}
		funcionario.setSalario(salario);
		funcionarioRepository.save(funcionario);
		
		return ResponseEntity.badRequest().body("Salário reajustado com sucesso!");	
	}

	public ResponseEntity<Iterable<Funcionario>> listarFuncionarios() {
		return new ResponseEntity<>( funcionarioRepository.findAll(), HttpStatus.ACCEPTED);
	}
}
