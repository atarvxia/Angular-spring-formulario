package com.ataraxia.formularioempleados.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ataraxia.formularioempleados.models.Comuna;
import com.ataraxia.formularioempleados.models.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region,Long>{
	
	public List<Region> findAll();
	
	public Optional<Region> findById(Long id);
	
	public Region findByName(String name);


}
