package com.tf.demo1.Aplicacao;

import com.tf.demo1.Dominio.DescontosImpostos.CalculaDescontos;
import com.tf.demo1.Dominio.DescontosImpostos.CalculaImpostos;
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
    private CalculaImpostos calculaImpostos;

    @Autowired
    private CalculaDescontos calculaDescontos;

    public Orcamento solicitar(String nomeCliente, List<ItemPedido> itemPedido) {
        validarEntrada(nomeCliente, itemPedido);

        long idOrcamento = servicoVendas.getNextOrcamentoId();
        double custoPedido = calcularCustoPedido(itemPedido);
        double impostoTotal = calculaImpostos.calcula(itemPedido, custoPedido, nomeCliente);
        double descontoTotal = calculaDescontos.calcula(itemPedido, custoPedido, nomeCliente);
        String dataHoje = obterDataFormatada();

        double custoTotal = custoPedido + impostoTotal - descontoTotal;
        boolean efetivado = false;

        Orcamento orcamento = new Orcamento(idOrcamento, nomeCliente, custoPedido, impostoTotal, dataHoje, descontoTotal, custoTotal, efetivado, itemPedido);

        // TODO: Implementar a persistência do orçamento no banco de dados
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
