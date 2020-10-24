package com.ufms.olx.domain.dto.PessoaDTO;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import com.ufms.olx.domain.enums.SituacaoPessoa;
import com.ufms.olx.domain.enums.TipoPessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CriaPessoaJuridicaDto {

    private Long id, idResponsavel;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
    @Enumerated(EnumType.STRING)
    private SituacaoPessoa situacaoPessoa;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String apelido, cnpj;
    private LocalDate dataNascimento;
}
