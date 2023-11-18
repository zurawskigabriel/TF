package com.tf.demo1.Persistencia;

import org.springframework.data.repository.CrudRepository;

import com.tf.demo1.Domínio.Orcamento;

import java.util.List;

public interface OrcamentoH2BD_ITF extends CrudRepository<Orcamento, Long> {
    Orcamento findByid(Long id);
    List<Orcamento> findAll();
    //Orcamento save(Orcamento o);
}
