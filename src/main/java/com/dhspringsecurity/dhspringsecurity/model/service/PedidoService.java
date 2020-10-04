package com.dhspringsecurity.dhspringsecurity.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dhspringsecurity.dhspringsecurity.model.entity.Pedido;
import com.dhspringsecurity.dhspringsecurity.model.repository.PedidoRepository;

@Service
public class PedidoService {
	private PedidoRepository pedidoRepository;

	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	public ResponseEntity<Iterable<Pedido>> listarPedidos() {
		return new ResponseEntity<>(pedidoRepository.findAll(), HttpStatus.ACCEPTED);
	}
	
	

}
