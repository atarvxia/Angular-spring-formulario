package com.ataraxia.formularioempleados.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ataraxia.formularioempleados.models.Comuna;
import com.ataraxia.formularioempleados.models.Empl;
import com.ataraxia.formularioempleados.models.Empleado;
import com.ataraxia.formularioempleados.models.Region;
import com.ataraxia.formularioempleados.service.FormularioService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormularioApi {
	@Autowired
	private FormularioService formularioService;
	
	//Obtener una lista de todas las entidades de la clase empleado.
	@GetMapping("/empleados")
	public List<Empl> getEmpleados(){
		return formularioService.getEmpls();
	}
	
	//Generar un nuevo empleado
    @PostMapping("/empleados")
    void addEmpleado(@RequestBody Empl empl) {
    	//Dado que comuna y region son solicitados como objetos en el modelo Empleado cree un modelo aparte llamado empl 
    	//que solicita region y comuna como strings, para luego crear una entidad empleado con esos datos y registrarla en la base
    	//de datos
    	Comuna comuna = formularioService.findComunaByName(empl.getComuna());
    	Region region = formularioService.findRegionByName(empl.getRegion());
    	
    	Empleado empleado = new Empleado(empl.getNombre(),empl.getApellido(),empl.getCorreo(),empl.getFechaNacimiento(),
    	empl.getTelefono(),comuna,region);
        formularioService.createEmpleado(empleado);
    }
    
    //Obtener los nombres de todas las comunas por región seleccionada.
	@GetMapping("/comunas/{name}")
	public List<String> getComunas(@PathVariable("name")String name){	
		Region region = formularioService.findRegionByName(name);
		List<String> comunas = new ArrayList<String>();
		List<Comuna> com= region.getComunas();		
		for(var i=0; i<com.size(); i++) {
			comunas.add(com.get(i).getNombre());
		}
		return comunas;
	}
	
	//Obtener los nombres de todas las regiones.
	@GetMapping("/regiones")
	public List<String> getRegions(){
		List<Region> regiones =  formularioService.findRegiones();
		List<String> regionesName = new ArrayList<String>();
		for(int i = 0; i < regiones.size(); i++) {
			regionesName.add(regiones.get(i).getName());
		}
		return regionesName;
	}
	//Borrar entidad empleado según id.
	@DeleteMapping("/delete/{id}")
	public void borrarEmpleado(@PathVariable("id")Long id) {
		formularioService.borrarEmpleado(id);
	}
	
	//Actualizar entidad empleado.
	@PutMapping("/actualizar")
	public void actualizarEmpleado(@RequestBody Empl empl) {
		formularioService.actualizarEmpleado(empl);
	}
	//Obtener entidad según id.
	@GetMapping("/find/{id}")
	public Empl getEmpleado(@PathVariable("id")Long id) {
		Empleado empleado = formularioService.findEmpleadoById(id);
		Empl empl = new Empl(empleado.getId(),empleado.getNombre(),empleado.getApellido(),
		empleado.getCorreo(),empleado.getFechaNacimiento(),empleado.getTelefono(),empleado.getRegion().getName(),
		empleado.getComuna().getNombre());
		return empl;
	}
	
	
}
