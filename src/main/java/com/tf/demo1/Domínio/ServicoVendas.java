package com.tf.demo1.Domínio;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ServicoVendas {
	public List<Orcamento> orcamentos;
	EstoqueH2BD_ITF estoque;
	@Autowired
	EfetivarOrcamento efetivar;

	@Autowired
	public ServicoVendas(EstoqueH2BD_ITF estoque) {
		this.estoque = estoque;
		Orcamento orcamento1 = new Orcamento((long) 1, 1, 100, 10, "10/10/2020", 0, 110, false, null);
		Orcamento orcamento2 = new Orcamento((long) 2, 2, 200, 20, "10/10/2020", 0, 220, false, null);
		orcamentos = List.of(orcamento1, orcamento2);
	}

	public boolean efetivarVenda(int nOrcamento){
		Orcamento orcamentoEfetivado;
		for (Orcamento i: orcamentos){
			if (i.getId() == nOrcamento) orcamentoEfetivado = i;
		}

		if (orcamentoEfetivado == null)
		return false;

		List<ItemPedido>itensOrcamento = orcamentoEfetivado.getItens();
		for (ItemPedido i: itensOrcamento){
			if (estoque.findByid(i.getCodigo()) != null){
				ItemDeEstoque produtoAtual = estoque.findByid(i.getCodigo());
				if (produtoAtual.getQuantidadeAtual < i.getQuantidade){
					return false;
				}
			}
		}

		//Baixa no estoque
		for (ItemPedido i: itensOrcamento){
			ItemDeEstoque produtoAtual = estoque.findByid(i.getCodigo());
			produtoAtual.setQuantidadeAtual(produtoAtual.getQuantidadeAtual() - i.getQuantidade);
			//Salva as alterações no banco de dados
		}

		efetivar.EfetivarOrcamento(nOrcamento);


		
	}

	public List<Orcamento> consultaOrcamentos() {
		return orcamentos;
	}

	public void armazenaOrcamento(Orcamento orcamento) {
		orcamentos.add(orcamento);
	}	

}
