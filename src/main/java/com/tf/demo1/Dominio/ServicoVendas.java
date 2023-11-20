package com.tf.demo1.Dominio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

@Component
public class ServicoVendas {
	private IRepOrcamentos orcamentosRepository;
	private IRepItemEstoque estoqueRepository;

	@Autowired
	public ServicoVendas(IRepOrcamentos orcamentosRepository, IRepItemEstoque estoqueRepository) {
		this.orcamentosRepository = orcamentosRepository;
		this.estoqueRepository = estoqueRepository;
	}

	public boolean efetivarVenda(int nOrcamento){
		Orcamento orcamentoEfetivado = orcamentosRepository.findByid((long) nOrcamento);

		//Verifica se o orçamento existe
		if (orcamentoEfetivado == null){
			return false;
		}

		// Verifica se o orçamento já foi efetivado
		List<ItemPedido>itensOrcamento = orcamentoEfetivado.getItens();
		for (ItemPedido i: itensOrcamento){
			if (estoqueRepository.findByid(i.getCodProduto()) != null){
				ItemDeEstoque produtoAtual = estoqueRepository.findByid(i.getCodProduto());
				if (produtoAtual.getQuantidadeAtual() < i.getQuantidade()){
					return false;
				}
			}
		}

		//Baixa no estoque
		for (ItemPedido i: itensOrcamento){
			ItemDeEstoque itemEstoque = estoqueRepository.findByid(i.getCodProduto());
			itemEstoque.setQuantidadeAtual(itemEstoque.getQuantidadeAtual() - i.getQuantidade());
			
			//Salva as alterações no banco de dados
			estoqueRepository.save(itemEstoque);
		}

		// Efetiva o orçamento
		orcamentoEfetivado.setEfetivado(true);

		// Salva as alterações no banco de dados
		orcamentosRepository.save(orcamentoEfetivado);

		// Retorna true para indicar que a venda foi efetivada
		return true;
	}

	public List<Orcamento> consultaOrcamentos() {
		return orcamentosRepository.findAll();
	}

	public void apagaOrcamento(Long id){
		orcamentosRepository.deleteById(id);
	}

	public void armazenaOrcamento(Orcamento orcamento) {
		orcamentosRepository.save(orcamento);
	}


	/*
	 * Retorna o próximo id disponível para item de estoque.
	 */
	@Transactional
	public Long getNextItemPedidoId() {
		// Busca o item com maior id...
		ItemDeEstoque ultimoItem = estoqueRepository.findTopByOrderByIdDesc();

		if (ultimoItem == null) { // Se não encontrou nenhum item, ele recebe o id 0...
			return 0L;
		} else { // Se encontrou o maior id, retorna maior + 1...
			return ultimoItem.getId() + 1;
		}
	}

	/*
	 * Retorna o próximo id disponível para item de estoque.
	 */
	@Transactional
	public Long getNextOrcamentoId() {
		// Busca o item com maior id...
		Orcamento ultimoItem = orcamentosRepository.findTopByOrderByIdDesc();

		if (ultimoItem == null) { // Se não encontrou nenhum item, ele recebe o id 0...
			return 0L;
		} else { // Se encontrou o maior id, retorna maior + 1...
			return ultimoItem.getId() + 1;
		}
	}

}
