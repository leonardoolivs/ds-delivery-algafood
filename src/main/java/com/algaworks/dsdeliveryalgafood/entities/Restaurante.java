package com.algaworks.dsdeliveryalgafood.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_RESTAURANTE")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal taxaFrete;

    private Boolean aberto;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    private Cozinha cozinha;

    @Embedded
    private Endereco endereco;

    @ManyToMany
    @JoinTable(name = "TB_RESTAURANTE_FORMAS_PAGAMENTO",
            joinColumns = @JoinColumn(name = "restaurante_id"),
            inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private Set<FormaPagamento> formasPagamento = new HashSet<>();

    @OneToMany(mappedBy = "restaurante")
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarFormaPagamento(FormaPagamento formaPagamento){
        this.formasPagamento.add(formaPagamento);
    }

    public void removerFormaPagamento(FormaPagamento formaPagamento){
        this.formasPagamento.remove(formaPagamento);
    }

    public void adicionarProduto(Produto produto){
        produto.setRestaurante(this);
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto){
        produto.setRestaurante(null);
        this.produtos.remove(produto);
    }


    @PrePersist
    public void persist(){
        aberto = Boolean.TRUE;
    }

}
