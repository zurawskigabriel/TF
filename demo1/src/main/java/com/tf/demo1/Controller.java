package Interface;

import Aplicacao.ProdutosDisponiveis_UC;
import Aplicacao.SolicitarOrcamento;
import Dominio.Orcamento;
import Dominio.Produto;
import Aplicacao.EfetivarOrcamento;
import Aplicacao.GerarRelatorio;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loja")
public class Controller {

	private ProdutosDisponiveis_UC produtosDisponiveis_UC;
	private SolicitarOrcamento solicitarOrcamento;
	private EfetivarOrcamento efetivarOrcamento;
	private GerarRelatorio gerarRelatorio;

	@GetMapping("/ProdutosDisponiveis")
    @CrossOrigin(origins = "*")
	public List<Produto> ProdutosDisponiveis() {
		return produtosDisponiveis_UC.ProdutosDisponiveis();
	}

	@GetMapping("/SolicitarOrcamento")
    @CrossOrigin(origins = "*")
	public Orcamento SolicitarOrcamento() {
		return solicitarOrcamento.SolicitarOrcamento();
	}

	@GetMapping("/EfetivarOrcamento")
    @CrossOrigin(origins = "*")
	public Bool EfetivarOrcamento() {
		return efetivarOrcamento.EfetivarOrcamento();
	}
	
	@GetMapping("/GerarRelatorio")
    @CrossOrigin(origins = "*")
	public Relatorio GerarRelatorio() {
		return gerarRelatorio.GerarRelatorio();
	}


}
