package com.tf.demo1.Dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicoEstoque {
    private final IRepProduto produtosRepository;

    @Autowired
    public ServicoEstoque(IRepProduto produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public List<Produto> todosProdutos() {
        return produtosRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Produto> produtosDisponiveis() {
        return produtosRepository.findProdutosDisponiveis();
    }
}
