package com.tf.demo1.Aplicacao;

import com.tf.demo1.Dominio.Descontos.GerenciaDescontos;
import com.tf.demo1.Dominio.Impostos.GerenciaImpostos;
import com.tf.demo1.Dominio.ItemPedido;
import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.ServicoVendas;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SolicitarOrcamentoTest {

    @Mock
    private ServicoVendas servicoVendas;

    @Mock
    private GerenciaImpostos gerenciaImpostos;

    @Mock
    private GerenciaDescontos gerenciaDescontos;

    @InjectMocks
    private SolicitarOrcamento solicitarOrcamento;

    @Test
    public void whenSolicitarOrcamento_thenReturnsOrcamento() {
        // Given
        String nomeCliente = "John Appleseed";

        List<ItemPedido> itensPedido = new ArrayList<>();
        itensPedido.add(new ItemPedido(100L, 2, 10.0));
        itensPedido.add(new ItemPedido(101L, 1, 5.0));

        double custoPedido = 25.0;
        double impostoTotal = 2.5;
        double descontoTotal = 1.0;

        given(gerenciaImpostos.calcula(itensPedido, custoPedido, nomeCliente)).willReturn(impostoTotal);
        given(gerenciaDescontos.calcula(itensPedido, custoPedido, nomeCliente)).willReturn(descontoTotal);

        // When
        Orcamento orcamento = solicitarOrcamento.solicitar(nomeCliente, itensPedido);

        // Then
        assertThat(orcamento.getCustoPedido()).isEqualTo(custoPedido);
        assertThat(orcamento.getCustoImposto()).isEqualTo(impostoTotal);
        assertThat(orcamento.getDesconto()).isEqualTo(descontoTotal);
        assertThat(orcamento.getTotalPagar()).isEqualTo(custoPedido + impostoTotal - descontoTotal);
        assertThat(orcamento.isEfetivado()).isFalse();
        assertThat(orcamento.getNomeCliente()).isEqualTo(nomeCliente);
        assertThat(orcamento.getData()).isNotNull();
        assertThat(orcamento.getItens()).hasSize(itensPedido.size());
    }
}