package com.tf.demo1.Interface;

import java.util.List;

import com.tf.demo1.Aplicacao.ListarTodosProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tf.demo1.Aplicacao.ProdutosDisponiveis;
import com.tf.demo1.Aplicacao.SolicitarOrcamento;
import com.tf.demo1.Dominio.IRepOrcamentos;
import com.tf.demo1.Dominio.ItemPedido;
import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.Produto;
import com.tf.demo1.Persistencia.OrcamentoH2BD_ITF;

@RestController
@RequestMapping("/loja")
public class Controller { 
	@Autowired
	ProdutosDisponiveis produtosDisponiveis;
	@Autowired
	SolicitarOrcamento solicitarOrcamento;
	@Autowired
	ListarTodosProdutos listarTodosProdutos;
	@Autowired
	OrcamentoH2BD_ITF repOrcamento;

//	@Autowired
//	EfetivarOrcamento efetivarOrcamento;

	@GetMapping("/produtos-disponiveis")
    @CrossOrigin(origins = "*")
	public List<Produto> produtosDisponiveis() {
		return produtosDisponiveis.ProdutosDisponiveis();
	}

	@PostMapping("/solicitar-orcamento")
    @CrossOrigin(origins = "*")
	public Orcamento solicitarOrcamento(@RequestParam final String nomeCliente, @RequestBody final List<ItemPedido> itemPedido) {
		return solicitarOrcamento.solicitar(nomeCliente, itemPedido);
	}

	@GetMapping("/orcamento-por-cliente")
    @CrossOrigin(origins = "*")
	public List<Orcamento> orcamentoPorCliente(@RequestParam(value = "nomeCliente") String nomeCliente) {
		return repOrcamento.findBynomeCliente(nomeCliente);
	}

//	@GetMapping("/efetivar-orcamento")
//    @CrossOrigin(origins = "*")
//	public boolean efetivarOrcamento(@RequestParam int idOrcamento) {
//		return efetivarOrcamento.Efetivar(idOrcamento);
//	}
	
	
	@GetMapping("/gerar-relatorio")
    @CrossOrigin(origins = "*")
	public String GerarRelatorio() {
		return "Loja";
	}

	/*
	 * Este endpoint retorna todos os produtos cadastrados no sistema.
	 */
	@GetMapping("/listar-todos-produtos")
	@CrossOrigin(origins = "*")
	public List<Produto> listarTodosProdutos() {
		return listarTodosProdutos.listarTodosProdutos();
	}

}
