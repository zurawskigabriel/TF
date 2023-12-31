package com.tf.demo1.Aplicacao;

import com.tf.demo1.Dominio.Descontos.GerenciaDescontos;
import com.tf.demo1.Dominio.Impostos.GerenciaImpostos;
import com.tf.demo1.Dominio.ItemPedido;
import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.ServicoVendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class SolicitarOrcamento {

    @Autowired
    private ServicoVendas servicoVendas;

    @Autowired
    private GerenciaImpostos gerenciaImpostos;

    @Autowired
    private GerenciaDescontos gerenciaDescontos;

    public Orcamento solicitar(String nomeCliente, List<ItemPedido> itemPedido) {
        validarEntrada(nomeCliente, itemPedido);

        double custoPedido = calcularCustoPedido(itemPedido);
        double impostoTotal = gerenciaImpostos.calcula(itemPedido, custoPedido, nomeCliente);
        double descontoTotal = gerenciaDescontos.calcula(itemPedido, custoPedido, nomeCliente);
        String dataHoje = obterDataFormatada();

        double custoTotal = custoPedido + impostoTotal - descontoTotal;
        boolean efetivado = false;

        Orcamento orcamento = new Orcamento();
        orcamento.setNomeCliente(nomeCliente);
        orcamento.setCustoPedido(custoPedido);
        orcamento.setCustoImposto(impostoTotal);
        orcamento.setDesconto(descontoTotal);
        orcamento.setTotalPagar(custoTotal);
        orcamento.setItens(itemPedido);
        orcamento.setData(dataHoje);
        orcamento.setEfetivado(efetivado);

        servicoVendas.salvarOrcamento(orcamento);

        return orcamento;
    }

    private void validarEntrada(String nomeCliente, List<ItemPedido> itemPedido) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio.");
        }
        if (itemPedido == null || itemPedido.isEmpty()) {
            throw new IllegalArgumentException("Lista de item pedido não pode ser nula ou vazia.");
        }
    }

    private double calcularCustoPedido(List<ItemPedido> itemPedido) {
        return itemPedido.stream().mapToDouble(item -> item.getPreco() * item.getQuantidade()).sum();
    }

    private String obterDataFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.now().format(formatter);
    }
}
