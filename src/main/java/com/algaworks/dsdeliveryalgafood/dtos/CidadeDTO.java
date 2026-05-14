package com.algaworks.dsdeliveryalgafood.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CidadeDTO {

    private Long id;
    private String nome;
    private EstadoDTO estado;

}
