package com.ms.produtos.domain.service;

import com.ms.produtos.domain.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    //Os em cinza são para implementações futuras

    List<Produto> listarProduto();
    Produto buscarProdutoId(Long id);
    List<Produto> buscarProdutoPorTipo(String tipo);
    Produto cadastrarProduto(Produto produto);
    void apagarProduto(Long id);
}
