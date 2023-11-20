package com.tf.demo1.Dominio.Impostos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tf.demo1.Dominio.ItemPedido;

@Component
public class ImpostoBase implements IImposto {
    public double calculaImposto(List<ItemPedido> itens, double custoPedido, String nomeCliente){
        return 0.1 * custoPedido;
    }
}
