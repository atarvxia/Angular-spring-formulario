package com.ataraxia.formularioempleados.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ataraxia.formularioempleados.models.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado,Long>{
	
	public List<Empleado> findAll();
	
	public Optional<Empleado> findById(Long id);
	
	

}
