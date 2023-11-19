package com.tf.demo1.Persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tf.demo1.Dominio.IRepItemEstoque;
import com.tf.demo1.Dominio.ItemDeEstoque;


public class RepItemEstoque implements IRepItemEstoque{
    @Autowired
    ItemEstoqueH2BD_ITF itemEstoques;

    @Override
    public ItemDeEstoque findByid(Long id) {
        return itemEstoques.findByid(id);
    }

    @Override
    public List<ItemDeEstoque> findAll() {
        return itemEstoques.findAll();
    }

}
