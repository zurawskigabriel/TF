package com.tf.demo1.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	private String descricao;
	private double precounitario;

	public Produto(Long codigo, String descricao, double precounitario){
		this.codigo = codigo;
		this.descricao = descricao;
		this.precounitario = precounitario;
	}

	protected Produto() {}

	public Long getCodigo(){
		return codigo;
	}

	public String getDescricao(){
		return descricao;
	}

	public double getPrecounitario(){
		return precounitario;
	}

	public void setCodigo(Long codigo){
		this.codigo = codigo;
	}

	public void setDescricao(String descricao){
		this.descricao = descricao;
	}

	public void setPrecoUnitario(double precounitario){
		this.precounitario = precounitario;
	}

}
