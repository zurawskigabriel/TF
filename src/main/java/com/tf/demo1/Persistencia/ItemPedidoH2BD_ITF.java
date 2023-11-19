package com.tf.demo1.Persistencia;

import org.springframework.data.repository.CrudRepository;

import com.tf.demo1.Dominio.ItemPedido;

import java.util.List;

public interface ItemPedidoH2BD_ITF extends CrudRepository<ItemPedido, Long>  {
    ItemPedido findByCodProduto(Long id);
    List<ItemPedido> findAll();
}
