package com.tf.demo1.Domínio;

import java.util.List;

public interface IRepItemEstoque {
    ItemDeEstoque findByid(Long id);
    List<ItemDeEstoque> findAll(); 
}
