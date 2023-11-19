package com.tf.demo1.Persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tf.demo1.Dominio.IRepOrcamentos;
import com.tf.demo1.Dominio.Orcamento;

public class RepOrcamentos implements IRepOrcamentos {
    @Autowired
    OrcamentoH2BD_ITF orcamentos;

    @Override
    public Orcamento findByid(Long id) {
        return orcamentos.findByid(id);
    }

    @Override
    public List<Orcamento> findAll() {
        return orcamentos.findAll();
    }

}
