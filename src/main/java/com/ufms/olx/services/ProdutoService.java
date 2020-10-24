package com.ufms.olx.services;

import com.ufms.olx.domain.dto.ProdutoDTO.CriaProdutoDTO;
import com.ufms.olx.domain.entities.Produto;
import com.ufms.olx.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public Produto insere(CriaProdutoDTO dto) {
        Produto produto = Produto.builder()
            .descricao(dto.getDescricao())
            .idadePermitida(dto.getIdadePermitida())
            .quantidadeEstoque(dto.getQuantidadeEstoque())
            .precoCompra(dto.getPrecoCompra())
            .precoVendaFisica(dto.getPrecoVendaFisica())
            .build();

        return repository.save(produto);
    }
}
