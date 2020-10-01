package com.zuniga.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuniga.model.Marca;
import com.zuniga.repo.IMarcaRepo;
import com.zuniga.service.IMarcaService;



@Service
public class MarcaServiceImpl implements IMarcaService{

	@Autowired	
	private IMarcaRepo repo;
	
	@Override
	public Marca registrar(Marca obj) {
		return repo.save(obj);
	}

	@Override
	public Marca modificar(Marca obj) {
		return repo.save(obj);
	}

	@Override
	public List<Marca> listar() {
		return repo.findAll();
	}

	@Override
	public Marca leerPorId(Integer id) {
		Optional<Marca> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Marca();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
