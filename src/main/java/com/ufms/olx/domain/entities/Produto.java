package com.ufms.olx.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String descricao;
  private Long quantidadeEstoque;
  private Integer idadePermitida;
  private double precoCompra;

  @Transient
  private double precoVendaFisica;
  @Transient
  private double precoVendaJuridica;
}
