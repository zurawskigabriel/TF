package com.tf.demo1.Domínio;

public class ItemPedido {

	private int codProduto;
	private int quantidade;
	private double preco;

	public ItemPedido(int codProduto, int quantidade, double preco){
		this.codProduto = codProduto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public int getCodProduto() {
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

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	
}
