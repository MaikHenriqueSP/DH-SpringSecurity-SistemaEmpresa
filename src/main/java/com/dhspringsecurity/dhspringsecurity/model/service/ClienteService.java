package com.dhspringsecurity.dhspringsecurity.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dhspringsecurity.dhspringsecurity.model.entity.Cliente;
import com.dhspringsecurity.dhspringsecurity.model.entity.Pedido;
import com.dhspringsecurity.dhspringsecurity.model.repository.ClienteRepository;
import com.dhspringsecurity.dhspringsecurity.model.repository.PedidoRepository;

@Service
public class ClienteService {
	private ClienteRepository clienteRepository;
	private PedidoRepository pedidoRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository, PedidoRepository pedidoRepository) {
		this.clienteRepository = clienteRepository;
		this.pedidoRepository = pedidoRepository;
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> getAllClientes() {
		return new ResponseEntity<Iterable<Cliente>>(clienteRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/cadastrarCliente")
	public ResponseEntity<Object> cadastrarCliente(@RequestBody Cliente cliente) {
		if (cliente == null) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar cliente!");
		}
		clienteRepository.save(cliente);
		return ResponseEntity.ok("Cliente cadastrado com sucesso!");
	}
	
	@PostMapping("/cadastrarPedido")
	public ResponseEntity<Object> cadastrarPedido(@RequestBody Pedido pedido) {
		if (pedido == null) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar pedido!");
		}
		pedidoRepository.save(pedido);
		return ResponseEntity.ok("Pedido cadastrado com sucesso!");		
	}

	
	

}
