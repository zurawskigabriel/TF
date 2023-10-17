package Dominio;

import Acesso_a_Dados.number;

public class Orcamento {

	private number id;

	private number idPedido;

	private number custoPedido;

	private number custoImposto;

	private number desconto;

	private number totalPagar;

	private boolean efetivado;

	private List<ItemPedido> itens;

	private ItemPedido[] itemPedido;

}
