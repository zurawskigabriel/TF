package com.tf.demo1.Aplicacao;

import com.tf.demo1.Aplicacao.Relatorio.DadosRelatorio;
import com.tf.demo1.Aplicacao.Relatorio.ServicoRelatorio;
import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.ServicoVendas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ServicoRelatorioTest {

    @Mock
    private ServicoVendas servicoVendas;

    @InjectMocks
    private ServicoRelatorio servicoRelatorio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void whenFiltraOrcamentosEfetivados_thenReturnOrcamentosFiltrados() {
//        // Given
//        Orcamento orcamento1 = new Orcamento();
//        orcamento1.setEfetivado(true);
//        Orcamento orcamento2 = new Orcamento();
//        orcamento2.setEfetivado(false);
//        when(servicoVendas.consultaOrcamentos()).thenReturn(Arrays.asList(orcamento1, orcamento2));
//
//        // When
//        List<Orcamento> efetivados = servicoRelatorio.filtraOrcamentosEfetivados();
//
//        // Then
//        assertEquals(1, efetivados.size());
//    }

    @Test
    void whenGerarDadosRelatorio_thenReturnDadosRelatorio() {
        // Given
        Orcamento orcEfetivado = new Orcamento();
        orcEfetivado.setEfetivado(true);
        when(servicoVendas.consultaOrcamentos()).thenReturn(Arrays.asList(orcEfetivado));

        // When
        List<DadosRelatorio> dadosRelatorios = servicoRelatorio.gerarDadosRelatorio(servicoRelatorio.filtraOrcamentosEfetivados());

        // Then
        assertEquals(1, dadosRelatorios.size());
        DadosRelatorio dados = dadosRelatorios.get(0);
        assertEquals(orcEfetivado.getData(), dados.getDataOrcamento());
        assertEquals(orcEfetivado.getCustoPedido(), dados.getValorBruto());
    }
}
