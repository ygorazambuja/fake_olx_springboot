package com.ufms.olx.domain.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.ufms.olx.domain.enums.SituacaoPessoa;
import com.ufms.olx.domain.enums.TipoPessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
public class PessoaFisica extends Pessoa {

    private String cpf;
    private String rg;

    @Builder(builderMethodName = "fisicaBuilder")
    private PessoaFisica(Long id, Long idResponsavel, TipoPessoa tipoPessoa, SituacaoPessoa situacaoPessoa, String nome,
            String apelido, LocalDate dataNascimento, String cpf, String rg) {
        super(id, idResponsavel, tipoPessoa, situacaoPessoa, nome, apelido, dataNascimento, null);
        this.cpf = cpf;
        this.rg = rg;
    }

}
