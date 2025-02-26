package com.entregable.ClienteApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entregable.ClienteApiRest.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {



}
