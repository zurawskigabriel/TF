package com.tf.demo1.Interface;

import java.util.List;

import com.tf.demo1.Aplicacao.ListarTodosProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tf.demo1.Aplicacao.GerarRelatorio;
import com.tf.demo1.Aplicacao.ProdutosDisponiveis;
import com.tf.demo1.Aplicacao.SolicitarOrcamento;
import com.tf.demo1.Domínio.ItemPedido;
import com.tf.demo1.Domínio.Orcamento;
import com.tf.demo1.Domínio.Produto;

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

    @CrossOrigin(origins = "*")
	public List<Produto> produtosDisponiveis() {
		return produtosDisponiveis.ProdutosDisponiveis();
	}

	/*@PostMapping("/SolicitarOrcamento")
    @CrossOrigin(origins = "*")
	public Orcamento solicitarOrcamento(@RequestBody final List<ItemPedido> itemPedido) {
		return solicitarOrcamento.solicitar(itemPedido);
	}

	@GetMapping("/EfetivarOrcamento")
//    @CrossOrigin(origins = "*")
//	public boolean efetivarOrcamento(@RequestParam int idOrcamento) {
//		return efetivarOrcamento.Efetivar(idOrcamento);
//	}
	
	
	@GetMapping("/GerarRelatorio")
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
