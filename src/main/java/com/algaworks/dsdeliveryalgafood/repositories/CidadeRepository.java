package com.algaworks.dsdeliveryalgafood.repositories;

import com.algaworks.dsdeliveryalgafood.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
