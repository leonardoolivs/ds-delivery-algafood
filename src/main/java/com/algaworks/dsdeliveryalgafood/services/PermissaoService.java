package com.algaworks.dsdeliveryalgafood.services;

import com.algaworks.dsdeliveryalgafood.entities.FormaPagamento;
import com.algaworks.dsdeliveryalgafood.entities.Grupo;
import com.algaworks.dsdeliveryalgafood.entities.Permissao;
import com.algaworks.dsdeliveryalgafood.entities.Restaurante;
import com.algaworks.dsdeliveryalgafood.exceptions.EntityNotFoundException;
import com.algaworks.dsdeliveryalgafood.repositories.PermissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PermissaoService {

    private final GrupoService service;
    private final PermissaoRepository repository;

    @Transactional(readOnly = true)
    public Set<Permissao> listar(Long grupoId){
        Grupo grupo = service.buscarPorId(grupoId);

        return grupo.getPermissoes();
    }

    @Transactional
    public void adicionarPermissaoNoGrupo(Long grupoId, Long permissaoId){
        Grupo grupo = service.buscarPorId(grupoId);
        Permissao permissao = buscarPorId(permissaoId);

        grupo.adicionarPermissao(permissao);
    }

    @Transactional
    public void removerPermissaoNoGrupo(Long grupoId, Long permissaoId){
        Grupo grupo = service.buscarPorId(grupoId);
        Permissao permissao = buscarPorId(permissaoId);

        grupo.removerPermissao(permissao);
    }

    @Transactional(readOnly = true)
    public Permissao buscarPorId(Long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Permissão com ID " + id + " não encontrado"));

    }
}
