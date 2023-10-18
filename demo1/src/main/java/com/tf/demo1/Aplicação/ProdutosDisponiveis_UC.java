package com.tf.demo1.Aplicação;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tf.demo1.Domínio.Produto;
import com.tf.demo1.Domínio.ServicoEstoque;

public class ProdutosDisponiveis_UC {

	private ServicoEstoque servicoEstoque;

	public ProdutosDisponiveis_UC() {
		this.servicoEstoque = servicoEstoque.getInstance();
	}

	public List<Produto> ProdutosDisponiveis() {
		return servicoEstoque.produtosDisponiveis();
	}

}
