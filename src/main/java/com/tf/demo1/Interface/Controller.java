package com.tf.demo1.Interface;

import java.util.List;

import com.tf.demo1.Aplicacao.EfetivarOrcamento;
import com.tf.demo1.Aplicacao.ListarTodosProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tf.demo1.Aplicacao.ProdutosDisponiveis;
import com.tf.demo1.Aplicacao.ServicoConsultaOrcamento;
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
	@Autowired
	ServicoConsultaOrcamento servicoConsultaOrcamento;

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
		return servicoConsultaOrcamento.consultaTodosOrcamentos();
	}

	/*
	 * Este endpoint retorna todos os orcamento de um cliente especifico.
	 */
	@GetMapping("/orcamento-por-cliente")
    @CrossOrigin(origins = "*")
	public List<Orcamento> orcamentoPorCliente(@RequestParam(value = "nomeCliente") String nomeCliente) {
		return servicoConsultaOrcamento.consultaOrcamentosPorCliente(nomeCliente);
	}

	/*
	 * Este endpoint retorna um orcamento com o Id correspondente.
	 */
	@GetMapping("/orcamento-por-id")
    @CrossOrigin(origins = "*")
	public Orcamento orcamentoPorId(@RequestParam(value = "Id") long Id) {
		return servicoConsultaOrcamento.consultaOrcamentosPorId(Id);
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
