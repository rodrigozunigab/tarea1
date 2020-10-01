package com.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zuniga.model.Marca;



public interface IMarcaRepo extends JpaRepository<Marca, Integer> {

}
