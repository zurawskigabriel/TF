package com.tf.demo1.Persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tf.demo1.Dominio.IRepItemEstoque;
import com.tf.demo1.Dominio.ItemDeEstoque;
import org.springframework.stereotype.Repository;

@Repository
public class RepItemEstoqueORM implements IRepItemEstoque {
    @Autowired
    ItemEstoqueH2BD_ITF itemEstoqueH2BD;

    @Override
    public ItemDeEstoque findByid(Long id) {
        return itemEstoqueH2BD.findByid(id);
    }

    @Override
    public List<ItemDeEstoque> findAll() {
        return itemEstoqueH2BD.findAll();
    }

    @Override
    public ItemDeEstoque save(ItemDeEstoque item) {
        return itemEstoqueH2BD.save(item);
    }

}
