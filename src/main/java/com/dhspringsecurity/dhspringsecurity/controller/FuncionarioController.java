package com.dhspringsecurity.dhspringsecurity.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhspringsecurity.dhspringsecurity.model.entity.Autorizacao;
import com.dhspringsecurity.dhspringsecurity.model.entity.Funcionario;
import com.dhspringsecurity.dhspringsecurity.model.repository.AutorizacaoRepository;
import com.dhspringsecurity.dhspringsecurity.model.repository.FuncionarioRepository;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {
	
	private FuncionarioRepository funcionarioRepository;
	private AutorizacaoRepository autorizacaoRepository;
		
	@Autowired
	public FuncionarioController(FuncionarioRepository funcionarioRepository, AutorizacaoRepository autorizacaoRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.autorizacaoRepository = autorizacaoRepository;
	}

	@PostMapping("/cadastrarFuncionario")
	public ResponseEntity<Void> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
		if (funcionario == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		funcionarioRepository.save(funcionario);
		Autorizacao autorizacao = new Autorizacao(funcionario.getEmail(), "ROLE_FUNCIONARIO");
		autorizacaoRepository.save(autorizacao);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/demitir/{id}")
	public ResponseEntity<Funcionario> demitirFuncionario(@PathVariable("id") Integer id){
		Optional<Funcionario> optFuncionario = funcionarioRepository.findById(id);
		if (optFuncionario.isEmpty()) {
			return new ResponseEntity<Funcionario>(HttpStatus.NO_CONTENT);
		}
		Funcionario funcionario = optFuncionario.get();
		funcionarioRepository.deleteById(id);
		autorizacaoRepository.deleteById(funcionario.getEmail());
		return new ResponseEntity<Funcionario>(funcionario,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/reajustarSalario/{id}")
	public ResponseEntity<Funcionario> reajustarSalario(@PathVariable Integer id, @RequestParam("salario") double salario ){
		Optional<Funcionario> optFuncionario = funcionarioRepository.findById(id);
		if(optFuncionario.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Funcionario funcionario =  optFuncionario.get();
		String cargo = autorizacaoRepository.findById(funcionario.getEmail()).get().getAutoridade();
		
		if (cargo.contains("GERENTE")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		funcionario.setSalario(salario);
		funcionarioRepository.save(funcionario);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
