package com.tf.demo1.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Dominio.Produto;
import com.tf.demo1.Dominio.ServicoEstoque;

@Component
public class ProdutosDisponiveis {
	@Autowired
	private ServicoEstoque servicoEstoque;

	public List<Produto> ProdutosDisponiveis() {
		return servicoEstoque.produtosDisponiveis();
	}

}
