package com.tf.demo1.Dominio.Descontos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Dominio.IRepOrcamentos;
import com.tf.demo1.Dominio.ItemPedido;

@Component
public class Desconto5Itens implements IDesconto {
    @Autowired
    IRepOrcamentos orcamentos;
    @Override
    public double calculaDesconto(List<ItemPedido> itens, double custoPedido, String nomeCliente) {
        if(itens.size() > 4) {
            return 0.05 * custoPedido;
        }
        return 0.0;
    }
}
