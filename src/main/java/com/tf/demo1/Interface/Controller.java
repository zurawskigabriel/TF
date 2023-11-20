package com.tf.demo1.Interface;

import java.util.List;

import com.tf.demo1.Aplicacao.EfetivarOrcamento;
import com.tf.demo1.Aplicacao.ListarTodosProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tf.demo1.Aplicacao.ProdutosDisponiveis;
import com.tf.demo1.Aplicacao.SolicitarOrcamento;
import com.tf.demo1.Dominio.ItemPedido;
import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.Produto;

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
	EfetivarOrcamento efetivarOrcamento;

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

	@GetMapping("/efetivar-orcamento")
    @CrossOrigin(origins = "*")
	public ResponseEntity<?> efetivarOrcamento(@RequestParam int idOrcamento) {
		boolean resposta = efetivarOrcamento.efetivar((long) idOrcamento);

		if (resposta) {
			return ResponseEntity.ok().body("Orçamento efetivado com sucesso.");
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
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
