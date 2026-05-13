package com.algaworks.dsdeliveryalgafood.services;

import com.algaworks.dsdeliveryalgafood.dtos.FormaPagamentoDTO;
import com.algaworks.dsdeliveryalgafood.entities.FormaPagamento;
import com.algaworks.dsdeliveryalgafood.exceptions.EntityNotFoundException;
import com.algaworks.dsdeliveryalgafood.repositories.FormaPagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormaPagamentoService {

    private final FormaPagamentoRepository repository;
    private final ModelMapper mapper;

    @Transactional
    public FormaPagamento cadastrar(FormaPagamentoDTO dto){

        FormaPagamento formaPagamento = mapper.map(dto, FormaPagamento.class);

        return repository.save(formaPagamento);
    }

    @Transactional(readOnly = true)
    public FormaPagamento buscarPorId(Long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Forma de Pagamento com ID " + id + " não encontrado"));

    }

    @Transactional(readOnly = true)
    public List<FormaPagamento> buscarTodos(){
        return repository.findAll();
    }

    @Transactional
    public void remover(Long id){
        FormaPagamento formaPagamento = buscarPorId(id);
        repository.deleteById(id);
    }
}
