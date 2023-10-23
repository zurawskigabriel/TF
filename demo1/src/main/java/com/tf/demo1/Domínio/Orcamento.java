package com.tf.demo1.Domínio;

import java.util.List;

public class Orcamento {

	private int id;
	private int idPedido;
	private double custoPedido;
	private double custoImposto;
	private double desconto;
	private double totalPagar;
	private boolean efetivado;
	private List<ItemPedido> itens;
	private String data;
	//private ItemPedido[] itemPedido;

	public Orcamento(int id, int idPedido, double custoPedido, double custoImposto, String data,
			double desconto, double totalPagar, boolean efetivado, List<ItemPedido> itens) {
		this.id = id;
		this.idPedido = idPedido;
		this.custoPedido = custoPedido;
		this.custoImposto = custoImposto;
		this.desconto = desconto;
		this.totalPagar = totalPagar;
		this.efetivado = efetivado;
		this.itens = itens;
		this.data = data;
	}

	

}
