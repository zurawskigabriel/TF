package com.tf.demo1.Aplicacao;

import com.tf.demo1.Aplicacao.Relatorio.DadosRelatorio;
import com.tf.demo1.Aplicacao.Relatorio.ServicoRelatorio;
import com.tf.demo1.Dominio.Orcamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GerarRelatorio {

    @Autowired
    private ServicoRelatorio servicoRelatorio;

    public List<DadosRelatorio> gerarRelatorio() {
        List<Orcamento> orcamentosEfetivados = servicoRelatorio.filtraOrcamentosEfetivados();

        return servicoRelatorio.gerarDadosRelatorio(orcamentosEfetivados);
    }
}
