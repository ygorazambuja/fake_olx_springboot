package com.ufms.olx.controllers;

import com.ufms.olx.domain.dto.PessoaDTO.CriaPessoaJuridicaDto;
import com.ufms.olx.domain.entities.PessoaJuridica;
import com.ufms.olx.services.PessoaJuricaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pessoaJuridica")
public class PessoaJuridicaController {
    @Autowired
    PessoaJuricaService pessoaJuridicaService;

    @PostMapping
    public ResponseEntity<?> insere(@RequestBody @Valid CriaPessoaJuridicaDto dto) {
        PessoaJuridica pessoaJuridica = pessoaJuridicaService.insere(dto);
        return ResponseEntity.ok().body(pessoaJuridica);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
        PessoaJuridica pessoa = pessoaJuridicaService.buscaPorId(id);
        return ResponseEntity.ok().body(pessoa);
    }
}
