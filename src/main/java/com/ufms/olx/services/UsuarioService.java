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

    public Usuario insere(CriaUsuarioDto dto, String login, String senha) {
        Usuario usuarioAutorizado = usuarioRepository.findUsuarioByLogin(login);
        if (usuarioAutorizado.getSenha().equals(senha)) {
            if (usuarioAutorizado.isAdministrador()) {
                Pessoa pessoa = pessoaService.buscaPorId(dto.getPessoaId());
                Usuario usuario = Usuario
                    .builder()
                    .isAdministrador(dto.isAdminstador())
                    .login(dto.getLogin())
                    .senha(dto.getSenha())
                    .pessoa(pessoa)
                    .build();
                return usuarioRepository.save(usuario);
            } else {
                return null;
            }
        }
        return null;
    }

    public Usuario buscaPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    public Usuario buscaPorLogin(String login) {
        return usuarioRepository.findUsuarioByLogin(login);
    }

    public Usuario insereAdmin(CriaUsuarioDto dto) {
        Pessoa pessoa = pessoaService.buscaPorId(dto.getPessoaId());
        Usuario usuario = Usuario
            .builder()
            .login("admin")
            .senha("admin")
            .pessoa(pessoa)
            .isAdministrador(true)
            .build();
        return usuarioRepository.save(usuario);
    }
}
