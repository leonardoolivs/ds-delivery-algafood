package com.algaworks.dsdeliveryalgafood.controllers;

import com.algaworks.dsdeliveryalgafood.dtos.RestauranteDTO;
import com.algaworks.dsdeliveryalgafood.entities.Restaurante;
import com.algaworks.dsdeliveryalgafood.services.CozinhaService;
import com.algaworks.dsdeliveryalgafood.services.RestauranteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteService service;

    @PostMapping
    public ResponseEntity<Restaurante> cadastrar(@RequestBody @Valid RestauranteDTO dto){

        Restaurante restaurante = service.cadastrar(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(restaurante.getId()).toUri();

        return ResponseEntity.created(uri).body(restaurante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscarPorId(@PathVariable Long id){
        Restaurante restaurante = service.buscarPorId(id);

        return ResponseEntity.ok(restaurante);
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> buscarTodos(){
        List<Restaurante> restaurantes = service.buscarTodas();

        return ResponseEntity.ok(restaurantes);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        Restaurante restaurante = service.buscarPorId(id);

        service.remover(restaurante.getId());
    }

    @PatchMapping("/{id}/fecharabrir")
    public void mudarStatusFecharAbrir(@PathVariable Long id){
        Restaurante restaurante = service.buscarPorId(id);

        service.mudarStatusFecharAbrir(id);
    }

}
