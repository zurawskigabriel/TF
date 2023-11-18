package com.tf.demo1.Interface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tf.demo1.Aplicação.EfetivarOrcamento;
import com.tf.demo1.Aplicação.GerarRelatorio;
import com.tf.demo1.Aplicação.ProdutosDisponiveis;
import com.tf.demo1.Aplicação.SolicitarOrcamento;
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
	EfetivarOrcamento efetivarOrcamento;

	@GetMapping("/ProdutosDisponiveis")
    @CrossOrigin(origins = "*")
	public List<Produto> ProdutosDisponiveis() {
		return produtosDisponiveis.ProdutosDisponiveis();
	}

	@PostMapping("/SolicitarOrcamento")
    @CrossOrigin(origins = "*")
	public Orcamento SolicitarOrcamento(@RequestBody final List<ItemPedido> itemPedido) {
		return solicitarOrcamento.Solicitar(itemPedido);
	}

	@GetMapping("/EfetivarOrcamento")
    @CrossOrigin(origins = "*")
	public boolean EfetivarOrcamento(@RequestParam int idOrcamento) {
		return efetivarOrcamento.Efetivar(idOrcamento);
	}
	
	
	@GetMapping("/GerarRelatorio")
    @CrossOrigin(origins = "*")
	public String GerarRelatorio() {
		return "Loja";
	}

}
