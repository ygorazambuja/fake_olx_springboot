package com.ufms.olx.services;

import com.ufms.olx.domain.dto.PessoaDTO.CriaPessoaDto;
import com.ufms.olx.domain.dto.PessoaDTO.CriaPessoaFisicaDto;
import com.ufms.olx.domain.dto.PessoaDTO.CriaPessoaJuridicaDto;
import com.ufms.olx.domain.entities.Pessoa;
import com.ufms.olx.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    PessoaFisicaService pessoaFisicaService;

    @Autowired
    PessoaJuricaService pessoaJuricaService;

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa inserePessoaFisicaOuJuridica(CriaPessoaDto dto) {
        if (dto.getCpf() == null && dto.getRg() == null && !dto.getCnpj().isEmpty()) {
            CriaPessoaJuridicaDto juridicaDto = CriaPessoaJuridicaDto
                .builder()
                .apelido(dto.getApelido())
                .cnpj(dto.getCnpj())
                .nome(dto.getNome())
                .dataNascimento(dto.getDataNascimento())
                .id(null)
                .idResponsavel(dto.getIdResponsavel())
                .situacaoPessoa(dto.getSituacaoPessoa())
                .tipoPessoa(dto.getTipoPessoa())
                .build();
            return pessoaJuricaService.insere(juridicaDto);
        } else {
            CriaPessoaFisicaDto fisicaDto = CriaPessoaFisicaDto
                .builder()
                .apelido(dto.getApelido())
                .cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento())
                .id(null)
                .rg(dto.getRg())
                .idResponsavel(dto.getIdResponsavel())
                .situacaoPessoa(dto.getSituacaoPessoa())
                .nome(dto.getNome())
                .tipoPessoa(dto.getTipoPessoa())
                .build();
            return pessoaFisicaService.insere(fisicaDto);
        }
    }

    public Pessoa buscaPorId(Long id) {
        return pessoaRepository.findById(id).orElseThrow();
    }

    public void deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }
}
