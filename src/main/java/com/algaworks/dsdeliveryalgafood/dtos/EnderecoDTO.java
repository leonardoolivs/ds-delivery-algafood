package com.algaworks.dsdeliveryalgafood.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

}
