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

	
}
