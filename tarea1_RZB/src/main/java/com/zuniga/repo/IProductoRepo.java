package com.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zuniga.model.Producto;


public interface IProductoRepo extends JpaRepository<Producto, Integer> {

}
