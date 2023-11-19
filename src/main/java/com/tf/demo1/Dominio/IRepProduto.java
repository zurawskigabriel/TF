package com.tf.demo1.Dominio;

import java.util.List;

public interface IRepProduto {
    Produto findBycodigo(Long codigo);
    List<Produto> findAll();
}
