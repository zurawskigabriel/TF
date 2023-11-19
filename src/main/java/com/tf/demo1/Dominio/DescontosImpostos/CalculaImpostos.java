package com.tf.demo1.Dominio.DescontosImpostos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Dominio.ItemPedido;

@Component
public class CalculaImpostos {
    @Autowired
    ImpostoBase impostoBase;

    public double calcula(List<ItemPedido> itens, double custoPedido, String nomeCliente) {
        double totalImpostos = 0;

        totalImpostos += impostoBase.calculaImposto(custoPedido);

        return totalImpostos;
    }
}
