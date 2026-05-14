package com.algaworks.dsdeliveryalgafood.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;

    @Email
    @Column(unique = true)
    private String email;
    private String senha;

}
