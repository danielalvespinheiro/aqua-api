package com.ms.produtos.api.v1.controller;

import com.ms.produtos.domain.model.Produto;
import com.ms.produtos.domain.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;


    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<Map<String, List<Produto>>> listarProdutos() {
        List<Produto> produtos = produtoService.listarProduto();


        Map<String, List<Produto>> response = new HashMap<>();
        response.put("produtos", produtos);


        return ResponseEntity.ok(response);
    }

    @GetMapping("buscar-produtos/{tipo}")
    public ResponseEntity<Map<String, List<Produto>>> buscarProdutoTipo(@PathVariable String tipo){
        List<Produto> prodTipo = produtoService.buscarProdutoPorTipo(tipo);


        Map<String, List<Produto>> response = new HashMap<>();
        response.put("produtos", prodTipo);

        System.out.println("Resultado da requisição de buscaTipo " + prodTipo);


        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody @Valid Produto produto) {
        Produto novoProduto = produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok(novoProduto);
    }
}