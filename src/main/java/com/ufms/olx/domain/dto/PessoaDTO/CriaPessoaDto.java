package com.ufms.olx.domain.dto.PessoaDTO;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.ufms.olx.domain.enums.SituacaoPessoa;
import com.ufms.olx.domain.enums.TipoPessoa;

import lombok.Data;

@Data
public class CriaPessoaDto {
    private Long id, idResponsavel;
    private TipoPessoa tipoPessoa;
    private SituacaoPessoa situacaoPessoa;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String apelido;
    private String cpf, rg, cnpj;
    private LocalDate dataNascimento;
}