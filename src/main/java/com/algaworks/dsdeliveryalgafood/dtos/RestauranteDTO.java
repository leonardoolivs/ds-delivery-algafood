package com.algaworks.dsdeliveryalgafood.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteDTO {

    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private Boolean aberto;
    private Long cozinhaId;
    private EnderecoDTO endereco;
    private FormaPagamentoDTO formaPagamento;

}
