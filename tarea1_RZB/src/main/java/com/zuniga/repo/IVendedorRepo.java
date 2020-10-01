package com.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zuniga.model.Vendedor;


public interface IVendedorRepo extends JpaRepository<Vendedor, Integer>{

}
