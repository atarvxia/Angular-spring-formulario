package com.ataraxia.formularioempleados.service;

import java.util.List;
import java.util.Optional;

import com.ataraxia.formularioempleados.models.Comuna;
import com.ataraxia.formularioempleados.models.Empl;
import com.ataraxia.formularioempleados.models.Empleado;
import com.ataraxia.formularioempleados.models.Region;

public interface FormularioService {
	
	List<Empleado> findEmpleados();
	
	List<Region> findRegiones();
	
	List<Comuna> findComunas();

	void createEmpleado(Empleado empleado);
	
	Region findRegionByName(String name);
	
	Comuna findComunaByName(String name);

	Region findRegionById(Long id);

	Comuna findComunaById(Long id);
	
	Empleado findEmpleadoById(Long id);

	List<Empl> getEmpls();

	void borrarEmpleado(Long id);

	void actualizarEmpleado(Empl empl);

}
