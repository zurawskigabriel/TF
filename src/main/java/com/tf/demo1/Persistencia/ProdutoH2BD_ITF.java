package com.tf.demo1.Persistencia;

import java.util.List;

import com.tf.demo1.Dominio.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoH2BD_ITF extends CrudRepository<Produto, Long> {
    Produto findBycodigo(Long codigo);
    List<Produto> findAll();

}
