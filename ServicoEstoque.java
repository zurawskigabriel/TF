package Dominio;

import java.util.List;

public class ServicoEstoque implements IRepProdutos, IRepItemEstoque{
	public List<Produto> produtos;

	public ServicoEstoque(){
		produto1 = new Produto (1, "Farofa", 10.5);
		produto2 = new Produto (2, "Banana", 3);
		produto3 =new Produto (3, "Trator", 1000.50);
		produto4 = new Produto (4, "Madeira", 5);
		produtos.add(produto1, produto2, produto3, produto4, produto5);
	}

	public List<Produto> produtosDisponiveis(){
		return produtos;
	}
}
