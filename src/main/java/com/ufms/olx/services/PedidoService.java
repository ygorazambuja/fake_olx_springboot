package com.ufms.olx.services;

import com.ufms.olx.domain.dto.PedidoDTO.CriaPedidoDTO;
import com.ufms.olx.domain.entities.Pedido;
import com.ufms.olx.domain.entities.Pessoa;
import com.ufms.olx.domain.enums.TipoPessoa;
import com.ufms.olx.repository.PedidoRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PessoaService pessoaService;

    public Pedido insere(CriaPedidoDTO dto) {
        Pessoa p = pessoaService.buscaPorId(dto.getIdPessoa());
        BigDecimal percentualDesconto = p.getTipoPessoa().equals(TipoPessoa.FISICA)
            ? BigDecimal.valueOf(0.1)
            : BigDecimal.valueOf(0.2);

        Pedido pedido = Pedido
            .builder()
            .statusPedido(dto.getStatusPedido())
            .dataCompra(dto.getDataCompra())
            .dataEntrega(dto.getDataEntrega())
            .idPessoa(dto.getIdPessoa())
            .build();
        pedido.setPercentualDesconto(percentualDesconto);
        pedido = repository.save(pedido);
        return pedido;
    }

    public List<Pedido> getAll() {
        return repository.findAll();
    }

    public Pedido getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new Error(""));
    }

    public Pedido updatePedido(Long id, Pedido pedido) {
        var backup = this.getById(id);
        pedido.setId(backup.getId());
        return repository.save(pedido);
    }

    public void deletePedido(Long id) {
        repository.deleteById(id);
    }
}
