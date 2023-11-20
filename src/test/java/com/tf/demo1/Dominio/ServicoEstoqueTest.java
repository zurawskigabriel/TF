package com.tf.demo1.Dominio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ServicoEstoqueTest {

    @Mock
    private IRepProduto produtosRepository;

    @InjectMocks
    private ServicoEstoque servicoEstoque;

    @Test
    public void whenTodosProdutos_thenReturnAllProdutos() {
        // Given
        Produto produto = new Produto();
        produto.setDescricao("Churrasqueira Controle Remoto");
        produto.setPrecoUnitario(1000.0);

        when(produtosRepository.findAll()).thenReturn(Arrays.asList(produto));

        // When
        List<Produto> foundProdutos = servicoEstoque.todosProdutos();

        // Then
        assertThat(foundProdutos).hasSize(1).extracting(Produto::getDescricao).containsOnly(produto.getDescricao());
    }

    @Test
    public void whenProdutosDisponiveis_thenReturnAvailableProdutos() {
        // Given
        Produto produto = new Produto();
        produto.setDescricao("PolyStation 5");
        produto.setPrecoUnitario(50.0);

        when(produtosRepository.findProdutosDisponiveis()).thenReturn(Arrays.asList(produto));

        // When
        List<Produto> foundProdutos = servicoEstoque.produtosDisponiveis();

        // Then
        assertThat(foundProdutos).containsOnly(produto);
    }
}