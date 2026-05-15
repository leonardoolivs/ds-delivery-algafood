package com.algaworks.dsdeliveryalgafood.repositories;

import com.algaworks.dsdeliveryalgafood.entities.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
