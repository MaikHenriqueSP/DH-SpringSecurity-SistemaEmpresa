package com.dhspringsecurity.dhspringsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhspringsecurity.dhspringsecurity.model.entity.Cliente;
import com.dhspringsecurity.dhspringsecurity.model.repository.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> getAllClientes() {
		return new ResponseEntity<Iterable<Cliente>>(clienteRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/cadastrarCliente")
	public ResponseEntity<Void> cadastrarCliente(@RequestBody Cliente cliente) {
		if (cliente == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		clienteRepository.save(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	

}
