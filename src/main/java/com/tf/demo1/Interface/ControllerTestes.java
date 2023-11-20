package com.tf.demo1.Interface;

import com.tf.demo1.Aplicacao.ListarTodosProdutos;
import com.tf.demo1.Aplicacao.ServicoConsultaOrcamento;
import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testes")
public class ControllerTestes {
    @Autowired
    private ServicoConsultaOrcamento servicoConsultaOrcamento;

    @Autowired
    private ListarTodosProdutos listarTodosProdutos;

    /*
     * Este endpoint retorna uma string para verificar se o servidor está online.
     */
    @GetMapping("/taVivoAí")
    @CrossOrigin(origins = "*")
    public String GerarRelatorio() {
        return "Pai ta on (～￣▽￣)～";
    }

    /*
     * Este endpoint retorna todos os orçamentos.
     */
    @GetMapping("/orcamentos")
    @CrossOrigin(origins = "*")
    public List<Orcamento> orcamentos() {
        return servicoConsultaOrcamento.consultaTodosOrcamentos();
    }

    /*
     * Este endpoint retorna todos os orçamento de um cliente específico.
     */
    @GetMapping("/orcamento-por-cliente")
    @CrossOrigin(origins = "*")
    public List<Orcamento> orcamentoPorCliente(@RequestParam(value = "nomeCliente") String nomeCliente) {
        return servicoConsultaOrcamento.consultaOrcamentosPorCliente(nomeCliente);
    }

    /*
     * Este endpoint retorna um orçamento com o Id correspondente.
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
