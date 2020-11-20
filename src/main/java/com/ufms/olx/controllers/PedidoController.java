package com.ufms.olx.controllers;

import com.ufms.olx.domain.dto.PedidoDTO.CriaPedidoDTO;
import com.ufms.olx.domain.entities.Pedido;
import com.ufms.olx.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(pedidoService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(pedidoService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alteraPedido(@RequestBody Pedido pedido, @PathVariable Long id) {
        Pedido pedidoAtualizado = pedidoService.updatePedido(id,  pedido);
        return ResponseEntity.ok().body(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaPessoa(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.ok().body("");
    }
}
