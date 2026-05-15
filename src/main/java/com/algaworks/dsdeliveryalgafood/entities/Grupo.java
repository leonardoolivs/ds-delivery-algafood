package com.algaworks.dsdeliveryalgafood.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_GRUPO")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(name = "TB_GRUPO_PERMISSOES",
            joinColumns = @JoinColumn(name = "grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private Set<Permissao> permissoes = new HashSet<>();

    @ManyToMany(mappedBy = "grupos")
    private List<Usuario> usuarios = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao){
        this.permissoes.add(permissao);
    }

    public void removerPermissao(Permissao permissao){
        this.permissoes.remove(permissao);
    }

}
