package com.tf.demo1.Domínio;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoH2BD_ITF extends CrudRepository<Produto, Long> {
    List<Produto> findBycodigo(Long codigo);
    List<Produto> findAll();

}
