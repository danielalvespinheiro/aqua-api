package com.ms.produtos.domain.service.impl;

import com.ms.produtos.domain.model.Produto;
import com.ms.produtos.domain.repository.ProdutoRepository;
import com.ms.produtos.domain.service.ProdutoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> listarProduto() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarProdutoId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("O produto informado não existe!"));
    }

    @Override
    public List<Produto> buscarProdutoPorTipo(String tipo) {
        System.out.println("Tipo recebido no serviço: " + tipo);
        List<Produto> produtos = produtoRepository.findByTipo(tipo);
        System.out.println("Produtos encontrados: " + produtos);
        return produtos;
    }

    @Override
    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void apagarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
