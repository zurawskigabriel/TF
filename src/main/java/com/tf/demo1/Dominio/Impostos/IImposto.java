package com.tf.demo1.Dominio.Impostos;

import java.util.List;

import com.tf.demo1.Dominio.ItemPedido;

public interface IImposto {
    double calculaImposto(List<ItemPedido> itens, double custoPedido, String nomeCliente);
}
