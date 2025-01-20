package com.bancojavar.demo_bancojavar_api.repository;

import com.bancojavar.demo_bancojavar_api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
