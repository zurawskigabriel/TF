package com.tf.demo1.Persistencia;

import java.util.List;

import com.tf.demo1.Dominio.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoH2BD_ITF extends CrudRepository<Produto, Long> {
    Produto findBycodigo(Long codigo);
    List<Produto> findAll();
    @Query("SELECT p FROM Produto p WHERE p.codigo IN (SELECT e.codProduto FROM ItemDeEstoque e)")
    List<Produto> findProdutosDisponiveis();
}
