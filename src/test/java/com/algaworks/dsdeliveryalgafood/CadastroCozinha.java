package com.algaworks.dsdeliveryalgafood;

import com.algaworks.dsdeliveryalgafood.entities.Cozinha;
import com.algaworks.dsdeliveryalgafood.entities.Restaurante;
import com.algaworks.dsdeliveryalgafood.exceptions.EntityNotFoundException;
import com.algaworks.dsdeliveryalgafood.services.CozinhaService;
import com.algaworks.dsdeliveryalgafood.services.RestauranteService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CadastroCozinha {

    @Autowired
    private CozinhaService service;

    @Autowired
    private RestauranteService restauranteService;

    @Test
    public void testCadastroCozinhaSucesso() {
        Cozinha cozinha = criarCozinha();

        assertThat(cozinha.getId()).isNotNull();
    }

    @Test
    public void testExcluiCozinhaIdCerto() {
        Cozinha cozinha = criarCozinha();

        service.remover(cozinha.getId());
    }

    @Test
    public void testErroExcluirCozinhaIdInexistente() {
        assertThrows(EntityNotFoundException.class, () -> service.remover(999L));
    }

    public void criarCozinha() {
        Cozinha cozinha = new Cozinha();
        cozinha.setNome("Brasileira");

    }

    public Restaurante criarRestaurante() {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("McDonalds");
        restaurante.setTaxaFrete(BigDecimal.valueOf(10.0));
        restaurante.setCozinha(criarCozinha());

        return restauranteService.cadastrar(restaurante);
    }

    @Test
    public void testErroExcluirCozinhaEmUsoEmOutraTabela() {
        Restaurante restaurante = criarRestaurante();

        assertThrows(DataIntegrityViolationException.class, () -> service.remover(restaurante.getCozinha().getId()));
    }

}
