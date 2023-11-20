package com.tf.demo1.Persistencia;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.tf.demo1.Dominio.ItemDeEstoque;

public interface ItemEstoqueH2BD_ITF extends CrudRepository<ItemDeEstoque, Long> {
    ItemDeEstoque findByid(Long id);
    List<ItemDeEstoque> findAll();
}
