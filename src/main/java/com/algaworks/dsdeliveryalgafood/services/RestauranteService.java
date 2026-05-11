package com.algaworks.dsdeliveryalgafood.services;

import com.algaworks.dsdeliveryalgafood.entities.Restaurante;
import com.algaworks.dsdeliveryalgafood.exceptions.EntityNotFoundException;
import com.algaworks.dsdeliveryalgafood.repositories.CozinhaRepository;
import com.algaworks.dsdeliveryalgafood.repositories.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauranteService {

    private final RestauranteRepository repository;

    @Transactional
    public Restaurante cadastrar(Restaurante restaurante){
        return repository.save(restaurante);
    }

    @Transactional(readOnly = true)
    public Restaurante buscarPorId(Long id){
        return repository.findById(id).orElseThrow(
                () ->  new EntityNotFoundException("Restaurante de  " + id + " não existe"));
    }

    @Transactional(readOnly = true)
    public List<Restaurante> buscarTodas(){
        return repository.findAll();
    }

    @Transactional
    public void remover(Long id){
        Restaurante restaurante = repository.findById(id).orElseThrow(
                () ->  new EntityNotFoundException("Restaurante de id " + id + " não existe"));

        repository.delete(restaurante);
    }
}
