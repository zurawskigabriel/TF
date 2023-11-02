package com.tf.demo1.Aplicação;

import com.tf.demo1.Domínio.ServicoEstoque;
import com.tf.demo1.Domínio.ServicoVendas;

public class EfetivarOrcamento {

	private ServicoVendas servicoVendas;
	private int idOrcamento;

	public EfetivarOrcamento(int idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public boolean Efetivar() {
		servicoVendas = ServicoVendas.getInstance();
		return servicoVendas.efetivarOrcamento(idOrcamento);
	}

}
