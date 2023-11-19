package com.tf.demo1.Aplicacao;

import com.tf.demo1.Domínio.Produto;
import com.tf.demo1.Domínio.ServicoEstoque;
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

