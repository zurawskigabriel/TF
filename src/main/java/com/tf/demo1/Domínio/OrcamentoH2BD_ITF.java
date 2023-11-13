package com.tf.demo1.Domínio;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrcamentoH2BD_ITF extends CrudRepository<Orcamento, Long> {
    List<Orcamento> findAll();
    Orcamento save(Orcamento o);
}
