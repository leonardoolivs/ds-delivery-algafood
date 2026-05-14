package com.algaworks.dsdeliveryalgafood.services;

import com.algaworks.dsdeliveryalgafood.entities.Cidade;
import com.algaworks.dsdeliveryalgafood.exceptions.EntityNotFoundException;
import com.algaworks.dsdeliveryalgafood.repositories.CidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository repository;

    @Transactional(readOnly = true)
    public Cidade buscarPorId(Long id){
        return repository.findById(id).orElseThrow(
                () ->  new EntityNotFoundException("Cidade de ID " + id + " não existe"));
    }

}
