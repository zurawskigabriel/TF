package com.tf.demo1.Domínio;

import java.util.List;

public interface IRepProduto {
    Produto findBycodigo(Long codigo);
    List<Produto> findAll();
}
