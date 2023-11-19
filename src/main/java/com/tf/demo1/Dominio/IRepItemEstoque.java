package com.tf.demo1.Dominio;

import java.util.List;

public interface IRepItemEstoque {
    ItemDeEstoque findByid(Long id);
    List<ItemDeEstoque> findAll();
    ItemDeEstoque findTopByOrderByIdDesc();
    ItemDeEstoque save(ItemDeEstoque item);
}
