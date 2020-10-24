package com.ufms.olx.controllers;

import com.ufms.olx.domain.dto.UsuarioDTO.CriaUsuarioDto;
import com.ufms.olx.domain.entities.Usuario;
import com.ufms.olx.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> insereUsuario(@RequestBody CriaUsuarioDto dto) {
        Usuario usuario = usuarioService.insere(dto);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.buscaPorId(id);
        return ResponseEntity.ok().body(usuario);
    }

}
