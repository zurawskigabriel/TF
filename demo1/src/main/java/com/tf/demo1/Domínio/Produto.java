package com.tf.demo1.Domínio;

public class Produto {
	private double codigo;
	private String descricao;
	private double precoUnitario;

	public Produto(double codigo, String descricao, double precoUnitario){
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
	}

	public double getCodigo(){
		return codigo;
	}

	public String getDescricao(){
		return descricao;
	}

	public double getPrecoUnitario(){
		return precoUnitario;
	}

}
