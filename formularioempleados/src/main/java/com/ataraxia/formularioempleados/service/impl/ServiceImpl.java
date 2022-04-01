package com.ataraxia.formularioempleados.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ataraxia.formularioempleados.models.Comuna;
import com.ataraxia.formularioempleados.models.Empl;
import com.ataraxia.formularioempleados.models.Empleado;
import com.ataraxia.formularioempleados.models.Region;
import com.ataraxia.formularioempleados.repositories.ComunaRepository;
import com.ataraxia.formularioempleados.repositories.EmpleadoRepository;
import com.ataraxia.formularioempleados.repositories.RegionRepository;
import com.ataraxia.formularioempleados.service.FormularioService;

@Service
public class ServiceImpl implements FormularioService{
	
	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	@Autowired
	private RegionRepository regionRepo;
	
	@Autowired
	private ComunaRepository comunaRepo;

	@Override
	public List<Empleado> findEmpleados() {
		
		return empleadoRepo.findAll();
	}
	
	@Override
	public List<Region> findRegiones(){
		return regionRepo.findAll();
	}
	
	@Override
	public List<Comuna> findComunas(){
		return comunaRepo.findAll();
	}
	
	@Override
	public void createEmpleado(Empleado empleado) {
		empleadoRepo.save(empleado);
	}
	
	@Override
	public Region findRegionByName(String name) {
		return regionRepo.findByName(name);
	}
	
	@Override
	public Comuna findComunaByName(String name) {
		return comunaRepo.findComunaByNombre(name);
	}
	
	@Override
	public Region findRegionById(Long id){
		Optional<Region> optionalRegion = regionRepo.findById(id);
		if(optionalRegion.isPresent()) {
			return optionalRegion.get();
		}
		else {
			return null;
		}
	}
	
	@Override
	public Comuna findComunaById(Long id){
		Optional<Comuna> optionalComuna = comunaRepo.findById(id);
		if(optionalComuna.isPresent()) {
			return optionalComuna.get();
		}
		else {
			return null;
		}
	}
	
	@Override
	public Empleado findEmpleadoById(Long id) {
		Optional<Empleado> optionalEmpleado = empleadoRepo.findById(id);
		if(optionalEmpleado.isPresent()) {
			return optionalEmpleado.get();
		}
		else {
			return null;
		}
	}
	
	@Override
	public void borrarEmpleado(Long id) {
		empleadoRepo.deleteById(id);
	}
	
	@Override
	public void actualizarEmpleado(Empl empl) {
    	Comuna comuna = comunaRepo.findComunaByNombre(empl.getComuna());
    	Region region = regionRepo.findByName(empl.getRegion());
		Empleado empleado = findEmpleadoById(empl.getId());
		if(empl.getNombre() != null) {
		empleado.setNombre(empl.getNombre());
		}
		if(empl.getApellido() != null) {
		empleado.setApellido(empl.getApellido());
		}
		if(empl.getCorreo() != null) {
		empleado.setCorreo(empl.getCorreo());
		}
		if(empl.getTelefono() != null) {
		empleado.setTelefono(empl.getTelefono());
		}
		if(empl.getFechaNacimiento() != null) {
		empleado.setFechaNacimiento(empl.getFechaNacimiento());
		}
		if(empl.getComuna() != null) {
		empleado.setComuna(comuna);
		}
		if(empl.getRegion() != null) {
		empleado.setRegion(region);
		}
		empleadoRepo.save(empleado);
	}
	@Override
	public List<Empl> getEmpls(){
		List<Region> regiones = findRegiones();
		List<Empl> empls = new ArrayList<Empl>();
		for(var i=0; i<regiones.size(); i++) {
			Region region = regiones.get(i);
			List<Empleado> empleados = region.getEmpleados();
			for(var j=0; j<empleados.size(); j++) {
				Empleado empleado = findEmpleadoById(empleados.get(j).getId());
				empls.add(new Empl(empleado.getId(),empleado.getNombre(),empleado.getApellido(),empleado.getCorreo(),
				empleado.getFechaNacimiento(),empleado.getTelefono(),region.getName(),empleado.getComuna().getNombre()));
			}
		}
		return empls;
	}
}
