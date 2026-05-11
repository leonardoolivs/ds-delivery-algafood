package com.algaworks.dsdeliveryalgafood.repositories;

import com.algaworks.dsdeliveryalgafood.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
