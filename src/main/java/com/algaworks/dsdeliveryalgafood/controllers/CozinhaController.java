package com.algaworks.dsdeliveryalgafood.controllers;

import com.algaworks.dsdeliveryalgafood.dtos.CozinhaDTO;
import com.algaworks.dsdeliveryalgafood.entities.Cozinha;
import com.algaworks.dsdeliveryalgafood.services.CozinhaService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cozinhas")
@RequiredArgsConstructor
public class CozinhaController {

    private final CozinhaService service;

    @PostMapping
    public ResponseEntity<Cozinha> cadastrar(@RequestBody CozinhaDTO dto){

        Cozinha cozinha = service.cadastrar(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(cozinha.getId()).toUri();

        return ResponseEntity.created(uri).body(cozinha);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscarPorId(@PathVariable Long id){
        Cozinha cozinha = service.buscarPorId(id);

        return ResponseEntity.ok(cozinha);
    }

    @GetMapping
    public ResponseEntity<List<Cozinha>> buscarTodos(){
        List<Cozinha> cozinhas = service.buscarTodas();

        return ResponseEntity.ok(cozinhas);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        Cozinha cozinha = service.buscarPorId(id);

        service.remover(cozinha.getId());
    }

}
