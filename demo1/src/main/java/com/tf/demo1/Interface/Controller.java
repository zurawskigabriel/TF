package com.tf.demo1.Interface;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tf.demo1.Aplicação.EfetivarOrcamento;
import com.tf.demo1.Aplicação.GerarRelatorio;
import com.tf.demo1.Aplicação.ProdutosDisponiveis_UC;
import com.tf.demo1.Aplicação.SolicitarOrcamento;
import com.tf.demo1.Domínio.ItemPedido;
import com.tf.demo1.Domínio.Orcamento;
import com.tf.demo1.Domínio.Produto;

@RestController
@RequestMapping("/loja")
public class Controller {

	private ProdutosDisponiveis_UC produtosDisponiveis_UC = new ProdutosDisponiveis_UC();
	private SolicitarOrcamento solicitarOrcamento = new SolicitarOrcamento();
	private EfetivarOrcamento efetivarOrcamento = new EfetivarOrcamento();
	private GerarRelatorio gerarRelatorio = new GerarRelatorio();

	@GetMapping("/ProdutosDisponiveis")
    @CrossOrigin(origins = "*")
	public List<Produto> ProdutosDisponiveis() {
		return produtosDisponiveis_UC.ProdutosDisponiveis();
	}

	@GetMapping("/SolicitarOrcamento")
    @CrossOrigin(origins = "*")
	public Orcamento SolicitarOrcamento(@RequestBody final ItemPedido itemPedido) {
		return solicitarOrcamento.SolicitarOrcamento(orcamento);
	}

	/*@GetMapping("/EfetivarOrcamento")
    @CrossOrigin(origins = "*")
	public Bool EfetivarOrcamento() {
		return efetivarOrcamento.EfetivarOrcamento();
	}
	
	@GetMapping("/GerarRelatorio")
    @CrossOrigin(origins = "*")
	public Relatorio GerarRelatorio() {
		return gerarRelatorio.GerarRelatorio();
	}*/


}
