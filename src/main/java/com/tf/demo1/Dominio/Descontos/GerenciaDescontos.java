package com.tf.demo1.Dominio.Descontos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Dominio.ItemPedido;

@Component
public class GerenciaDescontos {
    @Autowired
    Desconto5Itens desconto5Itens;
    @Autowired
    DescontoMaisDe10ComprasEm6Meses descontoMaisDe10ComprasEm6Meses;
    @Autowired
    DescontoMediaUltimas3Compras descontoMediaUltimas3Compras;

    public double calcula(List<ItemPedido> itens, double custoPedido, String nomeCliente) {
        double totalDescontos = 0;

        totalDescontos += desconto5Itens.calculaDesconto(itens, custoPedido, nomeCliente);

        double DescontoMaisDe10ComprasEm6Meses = descontoMaisDe10ComprasEm6Meses.calculaDesconto(itens, custoPedido, nomeCliente);
        double DescontoMediaUltimas3Compras = descontoMediaUltimas3Compras.calculaDesconto(itens, custoPedido, nomeCliente);

        if(DescontoMaisDe10ComprasEm6Meses >= DescontoMediaUltimas3Compras){
            totalDescontos += DescontoMaisDe10ComprasEm6Meses;
        } else {
            totalDescontos += DescontoMediaUltimas3Compras;
        }

        return totalDescontos;
    }
}
