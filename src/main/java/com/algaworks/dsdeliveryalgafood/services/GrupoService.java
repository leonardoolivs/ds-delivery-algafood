package com.algaworks.dsdeliveryalgafood.services;

import com.algaworks.dsdeliveryalgafood.dtos.GrupoDTO;
import com.algaworks.dsdeliveryalgafood.entities.Grupo;
import com.algaworks.dsdeliveryalgafood.repositories.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository repository;
    private final ModelMapper mapper;

    @Transactional
    public Grupo cadastrar(GrupoDTO dto){
        Grupo grupo = mapper.map(dto, Grupo.class);

        return repository.save(grupo);
    }
}
