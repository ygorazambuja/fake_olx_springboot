package com.ufms.olx.domain.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.ufms.olx.domain.enums.SituacaoPessoa;
import com.ufms.olx.domain.enums.TipoPessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column
    private Long id;
    private Long idResponsavel;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
    @Enumerated(EnumType.STRING)
    private SituacaoPessoa situacaoPessoa;
    private String nome;
    private String apelido;
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
}
