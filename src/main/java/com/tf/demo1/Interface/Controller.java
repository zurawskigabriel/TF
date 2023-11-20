package com.tf.demo1.Interface;

import java.util.List;

import com.tf.demo1.Aplicacao.*;
import com.tf.demo1.Aplicacao.Relatorio.DadosRelatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	EfetivarOrcamento efetivarOrcamento;

	@Autowired
	private GerarRelatorio gerarRelatorio;

	/*
	 * Este endpoint retorna todos os orçamentos.
	 */
	@GetMapping("/produtos-disponiveis")
    @CrossOrigin(origins = "*")
	public List<Produto> produtosDisponiveis() {
		return produtosDisponiveis.ProdutosDisponiveis();
	}

	/*
	 * Este endpoint solicita um orçamento.
	 */
	@PostMapping("/solicitar-orcamento")
    @CrossOrigin(origins = "*")
	public Orcamento solicitarOrcamento(@RequestParam final String nomeCliente, @RequestBody final List<ItemPedido> itemPedido) {
		return solicitarOrcamento.solicitar(nomeCliente, itemPedido);
	}

	/*
	 * Este endpoint efetiva um orçamento.
	 */
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

	/*
	 * Este endpoint gera um relatório contendo os orçamentos efetivados.
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/dados-relatorio")
	public ResponseEntity<List<DadosRelatorio>> getDadosRelatorio() {
		List<DadosRelatorio> dadosRelatorio = gerarRelatorio.gerarRelatorio();

		return ResponseEntity.ok(dadosRelatorio);
	}
}
