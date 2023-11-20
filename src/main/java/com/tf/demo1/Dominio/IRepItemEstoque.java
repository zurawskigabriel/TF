package com.tf.demo1.Dominio;

import java.util.List;

public interface IRepItemEstoque {
    ItemDeEstoque findByid(Long id);
    List<ItemDeEstoque> findAll();
    ItemDeEstoque save(ItemDeEstoque item);

    ItemDeEstoque findByCodProduto(Long codProduto);
}
