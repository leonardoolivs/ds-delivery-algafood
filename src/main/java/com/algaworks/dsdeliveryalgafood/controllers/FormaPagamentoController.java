package com.algaworks.dsdeliveryalgafood.controllers;

import com.algaworks.dsdeliveryalgafood.dtos.FormaPagamentoDTO;
import com.algaworks.dsdeliveryalgafood.entities.FormaPagamento;
import com.algaworks.dsdeliveryalgafood.services.FormaPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/formaspagamento")
@RequiredArgsConstructor
public class FormaPagamentoController {

    private final FormaPagamentoService service;

    @PostMapping
    public ResponseEntity<FormaPagamento> cadastrar(@RequestBody FormaPagamentoDTO dto){
        FormaPagamento formaPagamento = service.cadastrar(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(formaPagamento.getId()).toUri();

        return ResponseEntity.created(uri).body(formaPagamento);
    }
}
