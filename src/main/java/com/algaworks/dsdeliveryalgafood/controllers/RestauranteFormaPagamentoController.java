package com.algaworks.dsdeliveryalgafood.controllers;

import com.algaworks.dsdeliveryalgafood.dtos.FormaPagamentoDTO;
import com.algaworks.dsdeliveryalgafood.entities.FormaPagamento;
import com.algaworks.dsdeliveryalgafood.services.RestauranteFormaPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurantes/{restauranteId}/formas-pagamento")
public class RestauranteFormaPagamentoController {

    private final RestauranteFormaPagamentoService service;

    @GetMapping
    public Set<FormaPagamento> listar(@PathVariable Long restauranteId){
        return service.buscarFormasPagamentoDoRestaurante(restauranteId);
    }

    @PostMapping("/{formaPagamentoId}")
    public void adicionarFormaPagamentoDoRestaurante(@PathVariable Long restauranteId, @PathVariable Long formaPagamentoId){
        service.adicionarFormaPagamentoDoRestaurante(restauranteId, formaPagamentoId);
    }

    @DeleteMapping("/{formaPagamentoId}")
    public void removerFormaPagamentoDoRestaurante(@PathVariable Long restauranteId, @PathVariable Long formaPagamentoId){
        service.removerFormaPagamentoDoRestaurante(restauranteId, formaPagamentoId);
    }

}
