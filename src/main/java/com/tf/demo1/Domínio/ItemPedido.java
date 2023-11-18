package com.tf.demo1.Domínio;

import jakarta.persistence.*;

@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codProduto;
	private int quantidade;
	private double preco;
	@ManyToOne
	@JoinColumn(name = "orcamento_id") // Cannot resolve column 'orcamento_id'
	private Orcamento orcamento; // This is the reference back to Orcamento

	public ItemPedido(Long codProduto, int quantidade, double preco, Orcamento orcamento) {
		this.codProduto = codProduto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.orcamento = orcamento;
	}

	protected ItemPedido() {}

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

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

}
