package com.tf.demo1.Domínio;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoEstoque {
	private EstoqueH2BD_ITF estoqueRepo;
	private  ProdutoH2BD_ITF produtosRepo;

	@Autowired
	private ServicoEstoque(EstoqueH2BD_ITF estoqueRepo, ProdutoH2BD_ITF produtosRepo){
		this.estoqueRepo = estoqueRepo;
		this.produtosRepo = produtosRepo;
	}

	public List<Produto> produtosDisponiveis() {
		Set<Integer> codigosEmEstoque = estoqueRepo.findAll().stream()
				.map(ItemDeEstoque::getCodProduto)
				.collect(Collectors.toSet());

		return produtosRepo.findAll().stream()
				.filter(p -> codigosEmEstoque.contains(p.getCodigo()))
				.collect(Collectors.toList());
	}
}
