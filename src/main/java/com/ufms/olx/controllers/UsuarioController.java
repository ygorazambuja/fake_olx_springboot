package com.ufms.olx.controllers;

import com.ufms.olx.domain.dto.UsuarioDTO.CriaUsuarioDto;
import com.ufms.olx.domain.entities.Usuario;
import com.ufms.olx.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @PostMapping
  public ResponseEntity<?> insereUsuario(@RequestBody CriaUsuarioDto dto,
                                         @RequestHeader("login") String login,
                                         @RequestHeader("senha") String senha) {


    Usuario usuario = usuarioService.insere(dto, login, senha);
    return ResponseEntity.ok().body(usuario);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
    Usuario usuario = usuarioService.buscaPorId(id);
    return ResponseEntity.ok().body(usuario);
  }

  @GetMapping("/login/{login}")
  public ResponseEntity<?> buscaPorLogin(@PathVariable("login") String login) {
    Usuario usuario = usuarioService.buscaPorLogin(login);
    return ResponseEntity.ok().body(usuario);
  }

}
