package com.tf.demo1.Dominio;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

@Component
public class ServicoEstoque {
	private IRepItemEstoque estoqueRepository;
	private IRepProduto produtosRepository;

	@Autowired
	private ServicoEstoque(IRepItemEstoque estoqueRepository, IRepProduto produtosRepository){
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
		Set<Long> codigosEmEstoque = estoqueRepository.findAll().stream()
				.map(ItemDeEstoque::getCodProduto)
				.collect(Collectors.toSet());

		// Verifica os produtos cujo código esta no set do estoque e retorna o resultado.
		return produtosRepository.findAll().stream()
				.filter(p -> codigosEmEstoque.contains(p.getCodigo()))
				.toList();
	}

	/*
	 * Retorna o próximo id disponível para item de estoque.
	 */
//	@Transactional
//	public Long getNextItemPedidoId() {
//		// Busca o item com maior id...
//		ItemDeEstoque ultimoItem = estoqueRepository.findTopByOrderByIdDesc();
//
//		if (ultimoItem == null) { // Se não encontrou nenhum item, ele recebe o id 0...
//			return 0L;
//		} else { // Se encontrou o maior id, retorna maior + 1...
//			return ultimoItem.getId() + 1;
//		}
//	}
}
