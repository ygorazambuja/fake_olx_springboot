package com.ufms.olx.controllers;

import com.ufms.olx.domain.dto.ItemPedidoDTO.ItemPedidoDTO;
import com.ufms.olx.domain.entities.ItemPedido;
import com.ufms.olx.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/itemPedido")
public class ItemPedidoController
    implements GenericController<ItemPedido, ItemPedidoDTO> {
    @Autowired
    private ItemPedidoService itemPedidoService;

    @Override
    @PostMapping
    public ResponseEntity<?> addEntity(ItemPedidoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> removeEntity(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateEntity(ItemPedido entity, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<?> getAllEntities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEntityById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
