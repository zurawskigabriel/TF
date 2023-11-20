package com.tf.demo1.Aplicacao.Relatorio;

import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.ServicoVendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoRelatorio {

    private final ServicoVendas vendas;

    @Autowired
    public ServicoRelatorio(ServicoVendas vendas) {
        this.vendas = vendas;
    }

    public List<Orcamento> filtraOrcamentosEfetivados() {
        List<Orcamento> todosOrcamentos = vendas.consultaOrcamentos();
        return todosOrcamentos.stream()
                .filter(Orcamento::isEfetivado)
                .collect(Collectors.toList());
    }

    public List<DadosRelatorio> gerarDadosRelatorio(List<Orcamento> orcamentosEfetivados) {
        return orcamentosEfetivados.stream()
                .map(orc -> new DadosRelatorio(
                        orc.getData(),
                        orc.getCustoPedido(),
                        orc.getCustoImposto(),
                        orc.getDesconto(),
                        orc.getTotalPagar()))
                .collect(Collectors.toList());
    }
}