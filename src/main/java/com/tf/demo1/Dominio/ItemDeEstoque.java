package com.tf.demo1.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemDeEstoque {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long codProduto;
	private int quantidadeAtual;
	private int estoqueMinimo;
	private int estoqueMaximo;

	public ItemDeEstoque(Long id, Long codProduto, int quantidadeAtual,
	int estoqueMinimo, int estoqueMaximo) {
		this.codProduto = codProduto;
		this.id = id;
		this.quantidadeAtual = quantidadeAtual;
		this.estoqueMinimo = estoqueMinimo;
		this.estoqueMaximo = estoqueMaximo;
	}

	protected ItemDeEstoque(){}

	public Long getId() {
		return id;
	}

	public Long getCodProduto() {
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

	public void setQuantidadeAtual(int quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public void setEstoqueMaximo(int estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
