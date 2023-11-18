package com.tf.demo1.Domínio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.tf.demo1.Aplicação.EfetivarOrcamento;
import com.tf.demo1.Persistencia.OrcamentoH2BD_ITF;

@Component
public class ServicoVendas {
	private OrcamentoH2BD_ITF orcamentosRepo;
	//@Autowired
	//EfetivarOrcamento efetivar;

	@Autowired
	public ServicoVendas(OrcamentoH2BD_ITF orcamentosRepo) {
		this.orcamentosRepo = orcamentosRepo;
	}

	/*public boolean efetivarVenda(int nOrcamento){
		List<Orcamento> orcamentos = orcamentosRepo.findAll();
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


		
	}*/

	public List<Orcamento> consultaOrcamentos() {
		return orcamentosRepo.findAll();
	}

	public void armazenaOrcamento(Orcamento orcamento) {
		orcamentosRepo.save(orcamento);
	}	

}
