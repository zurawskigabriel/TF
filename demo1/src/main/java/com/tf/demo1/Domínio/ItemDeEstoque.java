package com.tf.demo1.Domínio;

public class ItemDeEstoque {

	private int id;
	private int codProduto;
	private int quantidadeAtual;
	private int estoqueMinimo;
	private int estoqueMaximo;
	private Produto produto;

	public ItemDeEstoque(int id, int codProduto, int quantidadeAtual,
	int estoqueMinimo, int estoqueMaximo, Produto produto) {
		this.codProduto = codProduto;
		this.id = id;
		this.quantidadeAtual = quantidadeAtual;
		this.estoqueMinimo = estoqueMinimo;
		this.estoqueMaximo = estoqueMaximo;
		this.produto = produto;
	}
}
