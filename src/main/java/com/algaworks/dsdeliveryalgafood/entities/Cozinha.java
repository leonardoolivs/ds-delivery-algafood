package com.algaworks.dsdeliveryalgafood.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_COZINHA")
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

}
