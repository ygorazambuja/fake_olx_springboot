package com.ufms.olx.services;

import com.ufms.olx.domain.dto.ItemPedidoDTO.ItemPedidoDTO;
import com.ufms.olx.domain.entities.ItemPedido;
import com.ufms.olx.domain.entities.Pedido;
import com.ufms.olx.domain.entities.Produto;
import com.ufms.olx.repository.ItemPedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemPedidoService implements GenericCRUDService<ItemPedido, ItemPedidoDTO> {
    @Autowired
    private ItemPedidoRepository repository;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ItemPedido insert(ItemPedidoDTO itemPedidoDto) {
        Pedido pedido = pedidoService.getById(itemPedidoDto.getPedidoId());
        Produto produto = produtoService.getById(itemPedidoDto.getProdutoId());

        ItemPedido itemPedido = ItemPedido
            .builder()
            .pedido(pedido)
            .produto(produto)
            .quantidade(itemPedidoDto.getQuantidade())
            .build();

        return repository.save(itemPedido);
    }

    @Override
    public ItemPedido update(ItemPedido itemPedido, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemPedido getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new Error(""));
    }

    @Override
    public List<ItemPedido> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
