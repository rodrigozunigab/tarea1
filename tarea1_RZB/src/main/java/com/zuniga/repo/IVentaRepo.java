package com.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zuniga.model.Venta;


public interface IVentaRepo extends JpaRepository<Venta, Integer>{

}
