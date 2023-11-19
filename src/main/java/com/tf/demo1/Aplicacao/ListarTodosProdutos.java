package com.tf.demo1.Aplicacao;

import com.tf.demo1.Dominio.Produto;
import com.tf.demo1.Dominio.ServicoEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarTodosProdutos {
    @Autowired
    private ServicoEstoque servicoEstoque;

    public List<Produto> listarTodosProdutos() {
        return servicoEstoque.todosProdutos();
    }
}

