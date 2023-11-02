package com.tf.demo1.Domínio;

import java.util.List;

public class ServicoVendas {
	public List<Orcamento> orcamentos;
	private static ServicoVendas instance;

	private ServicoVendas() {
		Orcamento orcamento1 = new Orcamento(1, 1, 100, 10, "10/10/2020", 0, 110, false, null);
		Orcamento orcamento2 = new Orcamento(2, 2, 200, 20, "10/10/2020", 0, 220, false, null);
		orcamentos = List.of(orcamento1, orcamento2);
	}

	public static ServicoVendas getInstance() {
		if (instance == null) {
			instance = new ServicoVendas();
		}
		return instance;
	}

	public List<Orcamento> consultaOrcamentos() {
		return orcamentos;
	}

	public void armazenaOrcamento(Orcamento orcamento) {
		orcamentos.add(orcamento);
	}	

}
