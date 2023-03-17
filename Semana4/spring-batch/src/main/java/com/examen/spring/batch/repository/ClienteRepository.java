package com.examen.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.spring.batch.entity.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente,Integer> {
}
