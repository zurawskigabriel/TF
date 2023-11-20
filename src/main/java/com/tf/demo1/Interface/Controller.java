package com.tf.demo1.Interface;

import java.util.List;

import com.tf.demo1.Aplicacao.ListarTodosProdutos;

import com.tf.demo1.Aplicacao.ProdutosDisponiveis;
import com.tf.demo1.Aplicacao.SolicitarOrcamento;
import com.tf.demo1.Dominio.IRepOrcamentos;
import com.tf.demo1.Dominio.ItemPedido;
import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loja")
public class Controller { 
	@Autowired
	ProdutosDisponiveis produtosDisponiveis;
	@Autowired
	SolicitarOrcamento solicitarOrcamento;
	@Autowired
	ListarTodosProdutos listarTodosProdutos;

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

//	@GetMapping("/efetivar-orcamento")
//    @CrossOrigin(origins = "*")
//	public boolean efetivarOrcamento(@RequestParam int idOrcamento) {
//		return efetivarOrcamento.Efetivar(idOrcamento);
//	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///// Endpoints de Testes
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * Este endpoint diz se o sistema está no ar.
	 */
	@GetMapping("/taVivoAí")
    @CrossOrigin(origins = "*")
	public String GerarRelatorio() {
		return "Pai ta on (～￣▽￣)～";
	}

	/*
	 * Este endpoint retorna todos os orcamentos.
	 */
	@GetMapping("/orcamentos")
    @CrossOrigin(origins = "*")
	public List<Orcamento> orcamentos() {
		return repOrcamento.findAll();
	}

	/*
	 * Este endpoint retorna todos os orcamento de um cliente especifico.
	 */
	@GetMapping("/orcamento-por-cliente")
    @CrossOrigin(origins = "*")
	public List<Orcamento> orcamentoPorCliente(@RequestParam(value = "nomeCliente") String nomeCliente) {
		return repOrcamento.findBynomeCliente(nomeCliente);
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
