package com.ufms.olx.controllers;

import com.ufms.olx.domain.dto.PedidoDTO.CriaPedidoDTO;
import com.ufms.olx.domain.entities.Pedido;
import com.ufms.olx.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
  @Autowired
  private PedidoService pedidoService;

  @PostMapping
  public ResponseEntity<?> insere(@RequestBody CriaPedidoDTO dto) {
    Pedido pedido = pedidoService.insere(dto);
    return ResponseEntity.ok().body(pedido);
  }

}
