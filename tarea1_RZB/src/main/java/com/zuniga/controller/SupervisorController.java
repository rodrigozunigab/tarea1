package com.zuniga.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zuniga.exception.ModeloNotFoundException;
import com.zuniga.model.Supervisor;
import com.zuniga.service.ISupervisorService;


@RestController
@RequestMapping("/supervisores")
public class SupervisorController {


	@Autowired
	private ISupervisorService service;
	
	@GetMapping
	public ResponseEntity<List<Supervisor>> listar(){
		 List<Supervisor> lista = service.listar();
		return new ResponseEntity<List<Supervisor>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Supervisor> listarPorId(@PathVariable("id") Integer id){
		Supervisor obj = service.leerPorId(id);
		if(obj.getIdSupervisor() == null) {
			throw new ModeloNotFoundException("ID SUPERVISOR NO ENCONTRADO(1) " + id);
		}
		return new ResponseEntity<Supervisor>(obj, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Supervisor supervisor) {
		Supervisor obj = service.registrar(supervisor);
		//marca/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(supervisor.getIdSupervisor()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Supervisor> modificar(@Valid @RequestBody Supervisor producto) {
		Supervisor obj = service.modificar(producto);
		return new ResponseEntity<Supervisor>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Supervisor obj = service.leerPorId(id);
		if(obj.getIdSupervisor() == null) {
			throw new ModeloNotFoundException("ID SUPERVISOR NO ENCONTRADO(2) " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}	
	
}
