package com.dhspringsecurity.dhspringsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhspringsecurity.dhspringsecurity.model.entity.Funcionario;
import com.dhspringsecurity.dhspringsecurity.model.repository.FuncionarioRepository;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
	
	private FuncionarioRepository funcionarioRepository;
		
	@Autowired
	public FuncionarioController(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Void> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
		if (funcionario == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		funcionarioRepository.save(funcionario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
