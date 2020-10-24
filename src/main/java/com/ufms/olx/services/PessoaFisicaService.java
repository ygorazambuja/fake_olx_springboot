package com.ufms.olx.services;

import com.ufms.olx.domain.dto.PessoaDTO.CriaPessoaFisicaDto;
import com.ufms.olx.domain.entities.PessoaFisica;
import com.ufms.olx.repository.PessoaFisicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService {
    @Autowired
    private PessoaFisicaRepository repository;

    public PessoaFisica insere(CriaPessoaFisicaDto dto) {
        PessoaFisica pessoaFisica = PessoaFisica.fisicaBuilder().apelido(dto.getApelido()).cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento()).id(null).idResponsavel(dto.getIdResponsavel())
                .nome(dto.getNome()).rg(dto.getRg()).situacaoPessoa(dto.getSituacaoPessoa())
                .tipoPessoa(dto.getTipoPessoa()).build();
        return repository.save(pessoaFisica);
    }

    public PessoaFisica buscaPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
