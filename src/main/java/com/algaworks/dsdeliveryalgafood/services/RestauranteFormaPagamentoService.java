package com.algaworks.dsdeliveryalgafood.services;

import com.algaworks.dsdeliveryalgafood.entities.FormaPagamento;
import com.algaworks.dsdeliveryalgafood.entities.Restaurante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RestauranteFormaPagamentoService {

    private final RestauranteService restauranteService;
    private final FormaPagamentoService formaPagamentoService;

        @Transactional(readOnly = true)
        public Set<FormaPagamento> buscarFormasPagamentoDoRestaurante(Long restauranteId){
            Restaurante restaurante = restauranteService.buscarPorId(restauranteId);

            return restaurante.getFormasPagamento();
        }

        @Transactional
        public void adicionarFormaPagamentoDoRestaurante(Long restauranteId, Long formaPagamentoId){
            Restaurante restaurante = restauranteService.buscarPorId(restauranteId);
            FormaPagamento formaPagamento = formaPagamentoService.buscarPorId(formaPagamentoId);

            restaurante.adicionarFormaPagamento(formaPagamento);
        }

        @Transactional
        public void removerFormaPagamentoDoRestaurante(Long restauranteId, Long formaPagamentoId){
            Restaurante restaurante = restauranteService.buscarPorId(restauranteId);
            FormaPagamento formaPagamento = formaPagamentoService.buscarPorId(formaPagamentoId);

            restaurante.removerFormaPagamento(formaPagamento);
        }

}
