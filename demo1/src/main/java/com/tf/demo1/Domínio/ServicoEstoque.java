package com.tf.demo1.Domínio;

import java.util.List;

public class ServicoEstoque implements IRepProdutos, IRepItemEstoque{
	public List<Produto> produtos;
	public static ServicoEstoque instance;

	private ServicoEstoque(){
		Produto produto1 = new Produto (1, "Farofa", 10.5);
		Produto produto2 = new Produto (2, "Banana", 3);
		Produto produto3 =new Produto (3, "Trator", 1000.50);
		Produto produto4 = new Produto (4, "Madeira", 5);
		Produto produto5 = new Produto (4, "RTX 4090", 10000);

		produtos = List.of(produto1, produto2, produto3, produto4, produto5);
	}

	public static ServicoEstoque getInstance(){
		if (instance == null){
			instance = new ServicoEstoque();
		}
		return new ServicoEstoque();
	}

	public List<Produto> produtosDisponiveis(){
		return produtos;
	}
}
