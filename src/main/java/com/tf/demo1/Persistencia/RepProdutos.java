package com.tf.demo1.Persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tf.demo1.Dominio.IRepProduto;
import com.tf.demo1.Dominio.Produto;
import com.tf.demo1.Dominio.ProdutoH2BD_ITF;

public class RepProdutos implements IRepProduto{
    @Autowired
    ProdutoH2BD_ITF produtos;

    @Override
    public Produto findBycodigo(Long codigo) {
        return produtos.findBycodigo(codigo);
    }

    @Override
    public List<Produto> findAll() {
        return produtos.findAll();
    }

}
