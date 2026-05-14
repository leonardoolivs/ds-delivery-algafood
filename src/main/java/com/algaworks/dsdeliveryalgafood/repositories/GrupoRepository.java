package com.algaworks.dsdeliveryalgafood.repositories;

import com.algaworks.dsdeliveryalgafood.entities.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
}
