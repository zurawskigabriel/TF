package com.tf.demo1.Dominio.Descontos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Dominio.IRepOrcamentos;
import com.tf.demo1.Dominio.ItemPedido;
import com.tf.demo1.Dominio.Orcamento;

@Component
public class DescontoMediaUltimas3Compras implements IDesconto {
    // Clientes com valor médio de suas últimas 3 compras superior a R$ 10 mil recebem 10% de desconto 
    // e a cada R$ 10 mil adicionais 5% adicionais até um limite de 30% de desconto
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Autowired
    IRepOrcamentos orcamentos;
    @Override
    public double calculaDesconto(List<ItemPedido> itens, double custoPedido, String nomeCliente) {
         List<Orcamento> ultimasCompras = orcamentos.findBynomeCliente(nomeCliente)
            .stream()
            .sorted(Comparator.comparing(orcamento -> LocalDate.parse(((Orcamento) orcamento).getData(), FORMATTER)).reversed())
            .limit(3)
            .collect(Collectors.toList());

        if (ultimasCompras.size() < 3) {
            return 0; 
        }

        double valorMedio = ultimasCompras.stream()
            .mapToDouble(Orcamento::getCustoPedido)
            .average()
            .orElse(0);

        double desconto = 0.1;
        for (double i = 20000; i <= valorMedio; i += 10000) {
            desconto += 0.05;
            if (desconto >= 0.30) {
                desconto = 0.30;
                break;
            }
        }

        return desconto * custoPedido;
    }
    
}
