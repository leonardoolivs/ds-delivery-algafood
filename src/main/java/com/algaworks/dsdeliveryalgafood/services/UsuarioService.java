package com.algaworks.dsdeliveryalgafood.services;

import com.algaworks.dsdeliveryalgafood.dtos.UsuarioDTO;
import com.algaworks.dsdeliveryalgafood.entities.Usuario;
import com.algaworks.dsdeliveryalgafood.exceptions.RegraDeNegocioException;
import com.algaworks.dsdeliveryalgafood.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final ModelMapper mapper;

    @Transactional
    public Usuario cadastrar(UsuarioDTO dto){
        Usuario usuario = mapper.map(dto, Usuario.class);

        if(repository.existsByEmail(dto.getEmail())){
            throw new RegraDeNegocioException("O email '" + dto.getEmail() + "' já esta sendo utilizado.");
        }

        return repository.save(usuario);
    }
}
