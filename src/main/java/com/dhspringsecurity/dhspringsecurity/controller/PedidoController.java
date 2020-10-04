package com.dhspringsecurity.dhspringsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhspringsecurity.dhspringsecurity.model.entity.Pedido;
import com.dhspringsecurity.dhspringsecurity.model.service.PedidoService;

@RestController
@RequestMapping("pedidos")
public class PedidoController {
	
	private PedidoService pedidoService;
	
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;		
	}

	@GetMapping
	public ResponseEntity<Iterable<Pedido>> listarPedidos() {
		return pedidoService.listarPedidos();
	}
}
