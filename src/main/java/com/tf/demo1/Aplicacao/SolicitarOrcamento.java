package com.tf.demo1.Aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Domínio.ItemPedido;
import com.tf.demo1.Domínio.Orcamento;
import com.tf.demo1.Domínio.ServicoVendas;

@Component
public class SolicitarOrcamento {

	@Autowired
	private ServicoVendas servicoVendas;

	public Orcamento solicitar(List<ItemPedido> itemPedido) {
		int id = 0;
		int idPedido = 0;
		double custoPedido = itemPedido.stream()
									   .mapToDouble(item -> item.getPreco() * item.getQuantidade())
									   .sum();

		double custoImposto = 0;
		double desconto = 0;

		// Formatar a data de hoje no formato desejado
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataHoje = LocalDate.now().format(formatter);

		double custoTotal = custoPedido + custoImposto;
		boolean efetivado = false;

		Orcamento orcamento = new Orcamento((long) id, idPedido, custoPedido, custoImposto, dataHoje, desconto, custoTotal, efetivado, itemPedido);

        // Salva o orçamento no banco de dados
		return orcamento; 
	}

}
