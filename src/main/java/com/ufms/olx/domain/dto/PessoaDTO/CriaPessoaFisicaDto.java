package com.ufms.olx.domain.dto.PessoaDTO;

import com.ufms.olx.domain.enums.SituacaoPessoa;
import com.ufms.olx.domain.enums.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CriaPessoaFisicaDto {

  private Long id, idResponsavel;
  @Enumerated(EnumType.STRING)
  private TipoPessoa tipoPessoa;
  @Enumerated(EnumType.STRING)
  private SituacaoPessoa situacaoPessoa;
  @NotEmpty
  private String nome;
  @NotEmpty
  private String apelido;

  @CPF
  @NotEmpty
  private String cpf;
  @NotEmpty
  private String rg;
  @DateTimeFormat
  private LocalDate dataNascimento;

}
