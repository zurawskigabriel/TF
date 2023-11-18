package com.tf.demo1.Domínio;

import java.util.List;

public interface IRepOrcamentos {
    Orcamento findByid(Long id);
    List<Orcamento> findAll();
    //Orcamento save(Orcamento o);
}
