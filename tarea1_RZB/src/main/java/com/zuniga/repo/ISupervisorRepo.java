package com.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zuniga.model.Supervisor;


public interface ISupervisorRepo extends JpaRepository<Supervisor, Integer> {

}
