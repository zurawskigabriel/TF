package com.tf.demo1.Domínio;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EstoqueH2BD_ITF extends CrudRepository<ItemDeEstoque, Long> {
    List<ItemDeEstoque> findByid(Long id);
    List<ItemDeEstoque> findAll();    
}
