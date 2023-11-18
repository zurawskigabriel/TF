package com.tf.demo1.Aplicação;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Domínio.Produto;
import com.tf.demo1.Domínio.ServicoEstoque;

@Component
public class ProdutosDisponiveis {
	@Autowired
	private ServicoEstoque servicoEstoque;

	public List<Produto> ProdutosDisponiveis() {
		return servicoEstoque.produtosDisponiveis();
	}

}
