package com.tf.demo1.Dominio.Descontos;

import java.util.List;

import com.tf.demo1.Dominio.ItemPedido;

public interface IDesconto {
    double calculaDesconto(List<ItemPedido> itens, double custoPedido, String nomeCliente);
}
