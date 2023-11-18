package com.tf.demo1.Domínio;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Orcamento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	//private int idPedido;
	private double custoPedido;
	private double custoImposto;
	private double desconto;
	private double totalPagar;
	private boolean efetivado;
	@OneToMany(mappedBy = "orcamento")
	private List<ItemPedido> itens;
	private String data;

	public Orcamento(Long id, int idPedido, double custoPedido, double custoImposto, String data,
			double desconto, double totalPagar, boolean efetivado, List<ItemPedido> itens) {
		this.id = id;
		//this.idPedido = idPedido;
		this.custoPedido = custoPedido;
		this.custoImposto = custoImposto;
		this.desconto = desconto;
		this.totalPagar = totalPagar;
		this.efetivado = efetivado;
		this.itens = itens;
		this.data = data;
	}

	protected Orcamento() {}

	public Long getId() {
		return id;
	}

	//public int getIdPedido() {
	//	return idPedido;
	//}

	public double getCustoPedido() {
		return custoPedido;
	}

	public double getCustoImposto() {
		return custoImposto;
	}

	public double getDesconto() {
		return desconto;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public boolean isEfetivado() {
		return efetivado;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public String getData() {
		return data;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//public void setIdPedido(int idPedido) {
	//	this.idPedido = idPedido;
	//}

	public void setCustoPedido(double custoPedido) {
		this.custoPedido = custoPedido;
	}

	public void setCustoImposto(double custoImposto) {
		this.custoImposto = custoImposto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public void setEfetivado(boolean efetivado) {
		this.efetivado = efetivado;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public void setData(String data) {
		this.data = data;
	}

}
