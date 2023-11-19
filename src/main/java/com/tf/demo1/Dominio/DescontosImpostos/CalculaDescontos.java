package com.tf.demo1.Dominio.DescontosImpostos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Dominio.ItemPedido;

@Component
public class CalculaDescontos {
    @Autowired
    Desconto5Itens desconto5Itens;
    public double calcula(List<ItemPedido> itens, double custoPedido, String nomeCliente) {
        double totalDescontos = 0;

        if(itens.size() > 5) {
            totalDescontos += desconto5Itens.calculaDesconto(custoPedido);
        }

        return totalDescontos;
    }
}
