package com.tf.demo1.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.ServicoEstoque;
import com.tf.demo1.Dominio.ServicoVendas;

@Component
public class ServicoConsultaOrcamento {
    @Autowired
    ServicoVendas servicoVendas;
    
    public List<Orcamento> consultaTodosOrcamentos(){
        return servicoVendas.consultaOrcamentos();
    }

    public Orcamento consultaOrcamentosPorId(long id){
        return servicoVendas.consultaOrcamentosPorId(id);
    }

    public List<Orcamento> consultaOrcamentosPorCliente(String nomeCliente){
        return servicoVendas.consultaOrcamentosPorCliente(nomeCliente);
    }
}
