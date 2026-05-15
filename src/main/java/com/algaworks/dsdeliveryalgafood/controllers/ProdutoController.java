package com.algaworks.dsdeliveryalgafood.controllers;

import com.algaworks.dsdeliveryalgafood.entities.Produto;
import com.algaworks.dsdeliveryalgafood.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurantes/{restauranteId}/produtos")
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> listar(@PathVariable Long restauranteId){
        List<Produto> produtos = service.listar(restauranteId);

        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> adicionarProdutoEmRestaurante(@PathVariable Long restauranteId, @RequestBody Produto produto){
        produto = service.adicionarProdutoEmRestaurante(restauranteId, produto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(produto);
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> removerProdutoEmRestaurante(@PathVariable Long restauranteId, @PathVariable Long produtoId){
        service.removerProdutoEmRestaurante(restauranteId, produtoId);

        return ResponseEntity.noContent().build();
    }
}
