package Dominio;

import Acesso_a_Dados.number;
import Acesso_a_Dados.String;

public class Produto {
	private number codigo;
	private String descricao;
	private number precoUnitario;

	public Produto(number codigo, String descricao, number precoUnitario){
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
	}

	public number getCodigo(){
		return codigo;
	}

	public String getDescricao(){
		return descricao;
	}

	public number getPrecoUnitario(){
		return precoUnitario;
	}

}
