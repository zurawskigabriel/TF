package com.tf.demo1.Domínio;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ServicoVendas {
	public List<Orcamento> orcamentos;

	public ServicoVendas() {
		Orcamento orcamento1 = new Orcamento((long) 1, 1, 100, 10, "10/10/2020", 0, 110, false, null);
		Orcamento orcamento2 = new Orcamento((long) 2, 2, 200, 20, "10/10/2020", 0, 220, false, null);
		orcamentos = List.of(orcamento1, orcamento2);
	}

	public List<Orcamento> consultaOrcamentos() {
		return orcamentos;
	}

	public void armazenaOrcamento(Orcamento orcamento) {
		orcamentos.add(orcamento);
	}	

}
