package com.tf.demo1.Persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tf.demo1.Dominio.IRepProduto;
import com.tf.demo1.Dominio.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class RepProdutosORM implements IRepProduto{
    @Autowired
    ProdutoH2BD_ITF produtoH2BD;

    @Override
    public Produto findBycodigo(Long codigo) {
        return produtoH2BD.findBycodigo(codigo);
    }

    @Override
    public List<Produto> findAll() {
        return produtoH2BD.findAll();
    }

}
