package com.ataraxia.formularioempleados.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ataraxia.formularioempleados.models.Comuna;

@Repository
public interface ComunaRepository extends CrudRepository<Comuna,Long>{
	public List<Comuna> findAll();
	public Optional<Comuna> findById(Long id);
	
	public Comuna findComunaByNombre(String name);
}
