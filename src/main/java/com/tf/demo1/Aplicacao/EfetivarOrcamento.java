package com.tf.demo1.Aplicacao;

import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.ServicoVendas;
import org.springframework.stereotype.Service;

@Service
public class EfetivarOrcamento {

	private final ServicoVendas servicoVendas;

	public EfetivarOrcamento(ServicoVendas servicoVendas) {
		this.servicoVendas = servicoVendas;
	}

	public boolean efetivar(Long idOrcamento) {
		Orcamento orcamento = servicoVendas.consultaOrcamento(idOrcamento);
		if (orcamento == null) {
			throw new IllegalArgumentException("Orçamento não encontrado");
		} else if (orcamento.isEfetivado()) {
			throw new IllegalArgumentException("Orçamento já efetivado");
		} else {
			orcamento.setEfetivado(true);
			servicoVendas.salvarOrcamento(orcamento);

			return true;
		}
	}
}
