package com.algaworks.dsdeliveryalgafood.services;

import com.algaworks.dsdeliveryalgafood.entities.Estado;
import com.algaworks.dsdeliveryalgafood.exceptions.EntityNotFoundException;
import com.algaworks.dsdeliveryalgafood.repositories.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EstadoService {

    private final EstadoRepository repository;

    @Transactional(readOnly = true)
    public Estado buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Estado de ID " + id + " não existe"));
    }
}