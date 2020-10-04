package com.dhspringsecurity.dhspringsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhspringsecurity.dhspringsecurity.model.entity.Funcionario;
import com.dhspringsecurity.dhspringsecurity.model.service.FuncionarioService;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {
	
	private FuncionarioService funcionarioService;

		
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Funcionario>> listarFuncionarios() {
		return funcionarioService.listarFuncionarios();
	}

	@PostMapping("/cadastrarFuncionario")
	public ResponseEntity<Object> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.cadastrarFuncionario(funcionario);
	}
	
	@DeleteMapping("/demitir/{id}")
	public ResponseEntity<Object> demitirFuncionario(@PathVariable("id") Integer id){
		return funcionarioService.demitirFuncionario(id);
	}
	
	@PutMapping("/reajustarSalario/{id}")
	public ResponseEntity<Object> reajustarSalario(@PathVariable Integer id, @RequestParam("salario") double salario ){
		return funcionarioService.reajustarSalario(id, salario);
	}
}
