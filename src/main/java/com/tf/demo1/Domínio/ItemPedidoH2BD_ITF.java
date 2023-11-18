package com.tf.demo1.Domínio;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemPedidoH2BD_ITF extends CrudRepository<ItemPedido, Long>  {
    ItemPedido findByCodProduto(Long id);
    List<ItemPedido> findAll();
}
