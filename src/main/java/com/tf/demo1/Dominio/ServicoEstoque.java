package com.tf.demo1.Dominio;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoEstoque {
	private final IRepItemEstoque estoqueRepository;
	private final IRepProduto produtosRepository;

	@Autowired
	public ServicoEstoque(IRepItemEstoque estoqueRepository, IRepProduto produtosRepository) {
		this.estoqueRepository = estoqueRepository;
		this.produtosRepository = produtosRepository;
	}

	public List<Produto> todosProdutos() {
		return produtosRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Produto> produtosDisponiveis() {
		return produtosRepository.findProdutosDisponiveis();
	}
}
