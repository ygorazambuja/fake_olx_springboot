package com.ufms.olx.controllers;

import javax.validation.Valid;

import com.ufms.olx.domain.dto.PessoaDTO.CriaPessoaFisicaDto;
import com.ufms.olx.domain.entities.PessoaFisica;
import com.ufms.olx.services.PessoaFisicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pessoaFisica")
public class PessoaFisicaController {

    @Autowired
    PessoaFisicaService pessoaFisicaService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> inserePessoaFisica(@RequestBody @Valid CriaPessoaFisicaDto dto) {
        PessoaFisica p = pessoaFisicaService.insere(dto);
        return ResponseEntity.ok().body(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
        PessoaFisica pessoa = pessoaFisicaService.buscaPorId(id);
        return ResponseEntity.ok().body(pessoa);
    }

}
