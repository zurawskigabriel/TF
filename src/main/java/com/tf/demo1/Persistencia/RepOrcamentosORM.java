package com.tf.demo1.Persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tf.demo1.Dominio.IRepOrcamentos;
import com.tf.demo1.Dominio.Orcamento;
import org.springframework.stereotype.Repository;

@Repository
public class RepOrcamentosORM implements IRepOrcamentos {
    @Autowired
    OrcamentoH2BD_ITF orcamentoH2BD;

    @Override
    public Orcamento findByid(Long id) {
        return orcamentoH2BD.findByid(id);
    }

    @Override
    public List<Orcamento> findAll() {
        return orcamentoH2BD.findAll();
    }

    @Override
    public Orcamento save(Orcamento orcamento) {
        return orcamentoH2BD.save(orcamento);
    }

    @Override
    public Orcamento findTopByOrderByIdDesc() {
        return orcamentoH2BD.findTopByOrderByIdDesc();
    }

}
