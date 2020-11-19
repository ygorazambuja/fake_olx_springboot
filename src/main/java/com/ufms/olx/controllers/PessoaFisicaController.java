package com.ufms.olx.controllers;

import com.ufms.olx.domain.dto.PessoaDTO.CriaPessoaFisicaDto;
import com.ufms.olx.domain.entities.PessoaFisica;
import com.ufms.olx.services.PessoaFisicaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pessoaFisica")
public class PessoaFisicaController {
    @Autowired
    PessoaFisicaService pessoaFisicaService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> inserePessoaFisica(
        @RequestBody @Valid CriaPessoaFisicaDto dto
    ) {
        return ResponseEntity.ok().body(pessoaFisicaService.insere(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
        PessoaFisica pessoa = pessoaFisicaService.buscaPorId(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @GetMapping
    public ResponseEntity<?> buscaTodos() {
        return ResponseEntity.ok().body(pessoaFisicaService.buscaTodos());
    }
}
