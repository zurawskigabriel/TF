package com.tf.demo1.Dominio;

import java.util.List;

public interface IRepOrcamentos {
    Orcamento findByid(Long id);
    List<Orcamento> findBynomeCliente(String nomeCliente);
    List<Orcamento> findAll();
    Orcamento save(Orcamento orcamento);
    Orcamento findTopByOrderByIdDesc();
}
