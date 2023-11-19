package com.tf.demo1.Dominio;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Persistencia.ItemEstoqueH2BD_ITF;

@Component
public class ServicoEstoque {
	private ItemEstoqueH2BD_ITF estoqueRepository;
	private ProdutoH2BD_ITF produtosRepository;

	@Autowired
	private ServicoEstoque(ItemEstoqueH2BD_ITF estoqueRepository, ProdutoH2BD_ITF produtosRepository){
		this.estoqueRepository = estoqueRepository;
		this.produtosRepository = produtosRepository;
	}

	/*
	 * Retorna todos os produtos cadastrados no sistema
	 */
	public List<Produto> todosProdutos() {
		return produtosRepository.findAll();
	}

	/*
	 * Retorna todos os produtos disponíveis no estoque
	 */
	public List<Produto> produtosDisponiveis() {
		// Cria um set com os códigos dos produtos que estão em estoque
		Set<Integer> codigosEmEstoque = estoqueRepository.findAll().stream()
				.map(ItemDeEstoque::getCodProduto)
				.collect(Collectors.toSet());

		// Retorna todos os produtos que estão em estoque
		return produtosRepository.findAll().stream()
				.filter(p -> codigosEmEstoque.contains(p.getCodigo()))
				.collect(Collectors.toList());
	}
}
