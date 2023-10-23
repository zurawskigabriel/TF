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

	public int getId() {
		return id;
	}

	public int getCodProduto() {
		return codProduto;
	}

	public int getQuantidadeAtual() {
		return quantidadeAtual;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public int getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setQuantidadeAtual(int quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public void setEstoqueMaximo(int estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
