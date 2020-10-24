package com.ufms.olx.controllers;

import com.ufms.olx.domain.dto.ProdutoDTO.CriaProdutoDTO;
import com.ufms.olx.domain.entities.Produto;
import com.ufms.olx.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> insere(@RequestBody CriaProdutoDTO dto) {
        Produto produto = produtoService.insere(dto);
        return ResponseEntity.ok().body(produto);
    }
}
