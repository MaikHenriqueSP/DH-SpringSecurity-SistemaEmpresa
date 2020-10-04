package com.dhspringsecurity.dhspringsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhspringsecurity.dhspringsecurity.model.entity.Cliente;
import com.dhspringsecurity.dhspringsecurity.model.entity.Pedido;
import com.dhspringsecurity.dhspringsecurity.model.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	private ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteRepository) {
		this.clienteService = clienteRepository;
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> listarClientes() {
		return clienteService.listarClientes();
	}
	
	@PostMapping("/cadastrarCliente")
	public ResponseEntity<Object> cadastrarCliente(@RequestBody Cliente cliente) {
		return clienteService.cadastrarCliente(cliente);
	}
	
	@PostMapping("/cadastrarPedido")
	public ResponseEntity<Object> cadastrarPedido(@RequestBody Pedido pedido) {
		return clienteService.cadastrarPedido(pedido);
	}

	
	

}
