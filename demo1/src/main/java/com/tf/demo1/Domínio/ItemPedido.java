package com.tf.demo1.Domínio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity
public class ItemPedido {

	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codProduto;
	private int quantidade;
	private double preco;

	public ItemPedido(Long codProduto, int quantidade, double preco){
		this.codProduto = codProduto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	//protected ItemPedido() {}

	public Long getCodProduto() {
		return codProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	
}
