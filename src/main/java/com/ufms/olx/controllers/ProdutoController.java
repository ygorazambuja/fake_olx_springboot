package com.ufms.olx.controllers;

import com.ufms.olx.domain.dto.ProdutoDTO.CriaProdutoDTO;
import com.ufms.olx.domain.entities.Produto;
import com.ufms.olx.services.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public ResponseEntity<?> getProdutos() {
        List<Produto> produtos = produtoService.getAll();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProdutoById(@PathVariable Long id) {
        return ResponseEntity.ok().body(produtoService.getById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProduto(
        @PathVariable Long id,
        @RequestBody Produto produto
    ) {
        Produto produtoAtualizado = produtoService.updateProduto(id, produto);
        return ResponseEntity.ok().body(produtoAtualizado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.ok().body("");
    }
}
