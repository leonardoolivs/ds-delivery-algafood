package com.algaworks.dsdeliveryalgafood.controllers;

import com.algaworks.dsdeliveryalgafood.dtos.GrupoDTO;
import com.algaworks.dsdeliveryalgafood.entities.Grupo;
import com.algaworks.dsdeliveryalgafood.services.GrupoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
public class GrupoController {

    private final GrupoService service;

    @PostMapping
    public ResponseEntity<Grupo> cadastrar(@RequestBody GrupoDTO dto){
        Grupo grupo = service.cadastrar(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(grupo.getId()).toUri();

        return ResponseEntity.created(uri).body(grupo);
    }
}
