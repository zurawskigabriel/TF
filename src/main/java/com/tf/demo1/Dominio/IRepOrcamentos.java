package com.tf.demo1.Dominio;

import java.util.List;

public interface IRepOrcamentos {
    Orcamento findByid(Long id);
    List<Orcamento> findAll();
    Orcamento save(Orcamento orcamento);
}
