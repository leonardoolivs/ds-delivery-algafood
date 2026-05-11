package com.algaworks.dsdeliveryalgafood.repositories;

import com.algaworks.dsdeliveryalgafood.entities.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
}
