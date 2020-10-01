package com.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zuniga.model.Cliente;


public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

}
