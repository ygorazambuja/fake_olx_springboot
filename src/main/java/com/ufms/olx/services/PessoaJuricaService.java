package com.ufms.olx.services;

import com.ufms.olx.domain.dto.PessoaDTO.CriaPessoaJuridicaDto;
import com.ufms.olx.domain.entities.PessoaJuridica;
import com.ufms.olx.repository.PessoaJuridicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaJuricaService {
    @Autowired
    private PessoaJuridicaRepository repository;

    public PessoaJuridica insere(CriaPessoaJuridicaDto dto) {
        PessoaJuridica pessoa = PessoaJuridica.pessoaJuridica().apelido(dto.getApelido()).cnpj(dto.getCnpj())
                .dataNascimento(dto.getDataNascimento()).id(null).idResponsavel(dto.getIdResponsavel())
                .nome(dto.getNome()).situacaoPessoa(dto.getSituacaoPessoa()).tipoPessoa(dto.getTipoPessoa()).build();
        return repository.save(pessoa);
    }

    public PessoaJuridica buscaPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
