package com.tf.demo1.Aplicação;

import java.util.List;

import com.tf.demo1.Domínio.ItemPedido;
import com.tf.demo1.Domínio.Orcamento;
import com.tf.demo1.Domínio.ServicoVendas;

public class SolicitarOrcamento {

	List<ItemPedido> itemPedido;
	private ServicoVendas servicoVendas;

	public SolicitarOrcamento(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Orcamento Solicitar() {
		int id = 0;
		int idPedido = 0;
		double custoPedido = itemPedido.stream()
									   .mapToDouble(produto -> produto.getProduto().getPrecoUnitario() * produto.getQuantidade())
									   .sum();

		double custoImposto = 0;
		double desconto = 0;
		String data = "10/10/2020";
		double custoTotal = custoPedido + custoImposto;
		boolean efetivado = false;

		Orcamento orcamento = new Orcamento(id, idPedido, custoPedido, custoImposto, data, desconto, custoTotal, efetivado, itemPedido);

		return orcamento; 
	}

}
