package com.ufms.olx.domain.entities;

import com.ufms.olx.domain.enums.SituacaoPessoa;
import com.ufms.olx.domain.enums.TipoPessoa;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class PessoaJuridica extends Pessoa {
    @Column(unique = true)
    private String cnpj;

    @Builder(builderMethodName = "pessoaJuridica")
    private PessoaJuridica(
        Long id,
        Long idResponsavel,
        TipoPessoa tipoPessoa,
        SituacaoPessoa situacaoPessoa,
        String nome,
        String apelido,
        LocalDate dataNascimento,
        String cnpj
    ) {
        super(
            id,
            idResponsavel,
            tipoPessoa,
            situacaoPessoa,
            nome,
            apelido,
            dataNascimento,
            null
        );
        this.cnpj = cnpj;
    }
}
