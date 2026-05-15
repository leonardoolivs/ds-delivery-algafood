package com.algaworks.dsdeliveryalgafood.controllers;

import com.algaworks.dsdeliveryalgafood.dtos.FormaPagamentoDTO;
import com.algaworks.dsdeliveryalgafood.entities.FormaPagamento;
import com.algaworks.dsdeliveryalgafood.entities.Permissao;
import com.algaworks.dsdeliveryalgafood.services.PermissaoService;
import com.algaworks.dsdeliveryalgafood.services.RestauranteFormaPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grupos/{grupoId}/permissoes")
public class PermissaoController {

    private final PermissaoService service;

    @GetMapping
    public Set<Permissao> listar(@PathVariable Long grupoId){
        return service.listar(grupoId);
    }

    @PutMapping("/{permissaoId}")
    public void adicionarPermissaoNoGrupo(@PathVariable Long grupoId, @PathVariable Long permissaoId){
        service.adicionarPermissaoNoGrupo(grupoId, permissaoId);
    }

    @DeleteMapping("/{permissaoId}")
    public void removerPermissaoNoGrupo(@PathVariable Long grupoId, @PathVariable Long permissaoId){
        service.removerPermissaoNoGrupo(grupoId, permissaoId);
    }

}
