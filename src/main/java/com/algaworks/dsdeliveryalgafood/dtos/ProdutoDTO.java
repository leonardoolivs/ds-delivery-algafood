package com.algaworks.dsdeliveryalgafood.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean ativo;

}
