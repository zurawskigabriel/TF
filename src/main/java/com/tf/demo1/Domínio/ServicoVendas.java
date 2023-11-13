package com.tf.demo1.Domínio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoVendas {
	private OrcamentoH2BD_ITF orcamentosRepo;

	@Autowired
	public ServicoVendas(OrcamentoH2BD_ITF orcamentosRepo) {
		this.orcamentosRepo = orcamentosRepo;
	}

	public List<Orcamento> consultaOrcamentos() {
		return orcamentosRepo.findAll();
	}

	public void armazenaOrcamento(Orcamento orcamento) {
		orcamentosRepo.save(orcamento);
	}	

}
