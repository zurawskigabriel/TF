package com.tf.demo1.Domínio;

public class ItemPedido {

	private int codProduto;
	private int quantidade;
	private Produto produto;

	public ItemPedido(int codProduto, int quantidade, Produto produto){
		this.codProduto = codProduto;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public int getCodProduto() {
		return codProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	
}
