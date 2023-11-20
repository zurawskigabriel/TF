package com.tf.demo1.Dominio.Descontos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Dominio.IRepOrcamentos;
import com.tf.demo1.Dominio.ItemPedido;

@Component
public class DescontoMaisDe10ComprasEm6Meses implements IDesconto {
    // Clientes com mais de 10 compras nos últimos 6 meses recebem desconto de 25%, indiferente do valor.
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Autowired
    IRepOrcamentos orcamentos;
    @Override
    public double calculaDesconto(List<ItemPedido> itens, double custoPedido, String nomeCliente) {
        LocalDate seisMesesAtras = LocalDate.now().minus(6, ChronoUnit.MONTHS);
        Long comprasDoClienteNosUltimos6Meses = orcamentos
                                              .findBynomeCliente(nomeCliente)
                                              .stream()
                                              .filter(orcamento -> orcamento.isEfetivado())
                                              .filter(orcamento -> {LocalDate dataOrcamento = LocalDate.parse(orcamento.getData(), FORMATTER);
                                                                    return dataOrcamento.isAfter(seisMesesAtras);})
                                              .count();
        
        if(comprasDoClienteNosUltimos6Meses > 10) {
            return 0.25 * custoPedido;
        } else {
            return 0;
        }
    }
    
}
