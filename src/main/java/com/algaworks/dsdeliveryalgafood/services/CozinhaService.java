package com.algaworks.dsdeliveryalgafood.services;

import com.algaworks.dsdeliveryalgafood.entities.Cozinha;
import com.algaworks.dsdeliveryalgafood.exceptions.EntityNotFoundException;
import com.algaworks.dsdeliveryalgafood.repositories.CozinhaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CozinhaService {

    private final CozinhaRepository repository;

    @Transactional
    public Cozinha cadastrar(Cozinha cozinha){
        return repository.save(cozinha);
    }

    @Transactional(readOnly = true)
    public Cozinha buscarPorId(Long id){
        return repository.findById(id).orElseThrow(
                () ->  new EntityNotFoundException("Cozinha de  " + id + " não existe"));
    }

    @Transactional(readOnly = true)
    public List<Cozinha> buscarTodas(){
        return repository.findAll();
    }

    @Transactional
    public void remover(Long id){
       Cozinha cozinha = repository.findById(id).orElseThrow(
                () ->  new EntityNotFoundException("Cozinha de  " + id + " não existe"));

       repository.delete(cozinha);
    }
}
