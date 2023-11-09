package com.tf.demo1.Domínio;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ServicoEstoque {
	public List<Produto> produtos;

	private ServicoEstoque(){
		Produto produto1 = new Produto ((long) 1, "Farofa", 10.5);
		Produto produto2 = new Produto ((long) 2, "Banana", 3);
		Produto produto3 = new Produto ((long) 3, "Trator", 1000.50);
		Produto produto4 = new Produto ((long) 4, "Madeira", 5);
		Produto produto5 = new Produto ((long) 5, "RTX 4090", 10000);

		produtos = List.of(produto1, produto2, produto3, produto4, produto5);
	}

	public List<Produto> produtosDisponiveis(){
		return produtos;
	}
}
