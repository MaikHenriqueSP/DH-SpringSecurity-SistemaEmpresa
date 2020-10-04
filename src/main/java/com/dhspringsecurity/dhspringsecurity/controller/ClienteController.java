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
import com.dhspringsecurity.dhspringsecurity.model.entity.Pedido;
import com.dhspringsecurity.dhspringsecurity.model.repository.ClienteRepository;
import com.dhspringsecurity.dhspringsecurity.model.repository.PedidoRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	private ClienteRepository clienteRepository;
	private PedidoRepository pedidoRepository;

	@Autowired
	public ClienteController(ClienteRepository clienteRepository, PedidoRepository pedidoRepository) {
		this.clienteRepository = clienteRepository;
		this.pedidoRepository = pedidoRepository;
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
	
	@PostMapping("/cadastrarPedido")
	public ResponseEntity<Void> cadastrarPedido(@RequestBody Pedido pedido) {

		if (pedido == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		pedidoRepository.save(pedido);
		return new ResponseEntity<>(HttpStatus.CREATED);		
	}

	
	

}
