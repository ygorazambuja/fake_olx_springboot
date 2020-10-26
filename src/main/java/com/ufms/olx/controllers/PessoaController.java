
package com.ufms.olx.controllers;

import com.ufms.olx.domain.dto.PessoaDTO.CriaPessoaDto;
import com.ufms.olx.domain.entities.Pessoa;
import com.ufms.olx.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

  @Autowired
  private PessoaService pessoaService;

  @PostMapping()
  public ResponseEntity<?> insereFisicaOuJuridica(@RequestBody CriaPessoaDto dto) {
    Pessoa pessoa = pessoaService.inserePessoaFisicaOuJuridica(dto);
    return ResponseEntity.ok().body(pessoa);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
    Pessoa pessoa = pessoaService.buscaPorId(id);
    return ResponseEntity.ok().body(pessoa);
  }

}
