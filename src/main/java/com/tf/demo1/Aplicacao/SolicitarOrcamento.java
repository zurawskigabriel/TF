package com.tf.demo1.Aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tf.demo1.Dominio.ItemPedido;
import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.ServicoVendas;
import com.tf.demo1.Dominio.Descontos.GerenciaDescontos;
import com.tf.demo1.Dominio.Impostos.GerenciaImpostos;





@Component
public class SolicitarOrcamento {

	@Autowired
	private ServicoVendas servicoVendas;
	@Autowired
	private GerenciaImpostos calculaImpostos;
	@Autowired
	private GerenciaDescontos calculaDescontos;

	public Orcamento solicitar(String nomeCliente, List<ItemPedido> itemPedido) {
		Long idOrcamento = servicoVendas.getNextOrcamentoId();
		double custoPedido = itemPedido.stream()
									   .mapToDouble(item -> item.getPreco() * item.getQuantidade())
									   .sum();

		double impostoTotal = calculaImpostos.calcula(itemPedido, custoPedido, nomeCliente);
		double descontoTotal = calculaDescontos.calcula(itemPedido, custoPedido, nomeCliente);

		// Formatar a data de hoje no formato desejado
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataHoje = LocalDate.now().format(formatter);

		double custoTotal = custoPedido + impostoTotal - descontoTotal;
		boolean efetivado = false;

		Orcamento orcamento = new Orcamento(idOrcamento, nomeCliente, custoPedido, impostoTotal, dataHoje, descontoTotal, custoTotal, efetivado, itemPedido);

        // Salva o orçamento no banco de dados
		return orcamento; 
	}

}
