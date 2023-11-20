package com.tf.demo1.Dominio;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoVendas {
	private final IRepOrcamentos orcamentosRepository;
	private final IRepItemEstoque estoqueRepository;

	@Autowired
	public ServicoVendas(IRepOrcamentos orcamentosRepository, IRepItemEstoque estoqueRepository) {
		this.orcamentosRepository = orcamentosRepository;
		this.estoqueRepository = estoqueRepository;
	}

	@Transactional
	public boolean efetivarVenda(Long nOrcamento){
		Orcamento orcamento = orcamentosRepository.findByid(nOrcamento);

		if (orcamento == null) {
			throw new IllegalArgumentException("Orçamento não encontrado");
		} else if (orcamento.isEfetivado()) {
			throw new IllegalArgumentException("Orçamento já efetivado");
		}

		List<ItemPedido> itensOrcamento = orcamento.getItens();
		for (ItemPedido item : itensOrcamento){
			ItemDeEstoque produtoAtual = estoqueRepository.findByCodProduto(item.getCodProduto());
			if (produtoAtual == null || produtoAtual.getQuantidadeAtual() < item.getQuantidade()){
				throw new IllegalStateException("Estoque insuficiente para o produto: " + item.getCodProduto());
			}
		}

		for (ItemPedido item : itensOrcamento){
			ItemDeEstoque itemEstoque = estoqueRepository.findByCodProduto(item.getCodProduto());
			itemEstoque.setQuantidadeAtual(itemEstoque.getQuantidadeAtual() - item.getQuantidade());
			estoqueRepository.save(itemEstoque);
		}

		orcamento.setEfetivado(true);
		salvarOrcamento(orcamento);

		return true;
	}

	public List<Orcamento> consultaOrcamentos() {
		return orcamentosRepository.findAll();
	}

	public Orcamento consultaOrcamentosPorId(long id) {
		return orcamentosRepository.findByid(id);
	}

	public List<Orcamento> consultaOrcamentosPorCliente(String nomeCliente) {
		return orcamentosRepository.findBynomeCliente(nomeCliente);
	}

	public void apagaOrcamento(Long id){
		orcamentosRepository.deleteByid(id);
	}

	public void armazenaOrcamento(Orcamento orcamento) {
		orcamentosRepository.save(orcamento);
	}

	// TODO: Concertar o erro de primary key violation
	public void salvarOrcamento(Orcamento orcamento) {
		// orcamentosRepository.save(orcamento);
	}
}