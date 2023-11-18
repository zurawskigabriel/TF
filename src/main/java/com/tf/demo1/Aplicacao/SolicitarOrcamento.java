package com.tf.demo1.Aplicacao;
/*package com.tf.demo1.Aplicação;

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

	public Orcamento Solicitar(List<ItemPedido> itemPedido) {
		int id = 0;
		int idPedido = 0;
		double custoPedido = itemPedido.stream()
									   .mapToDouble(item -> item.getPreco() * item.getQuantidade())
									   .sum();

		double custoImposto = 0;
		double desconto = 0;
		String data = "10/10/2020";
		double custoTotal = custoPedido + custoImposto;
		boolean efetivado = false;

		Orcamento orcamento = new Orcamento((long) id, idPedido, custoPedido, custoImposto, data, desconto, custoTotal, efetivado, itemPedido);

		return orcamento; 
	}

}*/
