package com.ufms.olx.services;

import com.ufms.olx.domain.dto.UsuarioDTO.CriaUsuarioDto;
import com.ufms.olx.domain.entities.Pessoa;
import com.ufms.olx.domain.entities.Usuario;
import com.ufms.olx.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario insere(CriaUsuarioDto dto) {
        Pessoa pessoa = pessoaService.buscaPorId(dto.getPessoaId());
        Usuario usuario = Usuario.builder().isAdministrador(dto.isAdminstador()).login(dto.getLogin())
                .senha(dto.getSenha()).pessoa(pessoa).build();
        return usuarioRepository.save(usuario);
    }

    public Usuario buscaPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }
}
