package com.ataraxia.formularioempleados.models;

public class Empl {
	
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private String correo;
	
	private String fechaNacimiento;
	
	private String telefono;

    private String region;
    
    private String comuna;
    
    public Empl() {}
    public Empl(String nombre, String apellido, String correo, String fechaNacimiento, String telefono, String region, String comuna){
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.correo = correo;
    	this.fechaNacimiento = fechaNacimiento;
    	this.telefono = telefono;
    	this.region = region;
    	this.comuna = comuna;
    }
    
    public Empl(Long id, String nombre, String apellido, String correo, String fechaNacimiento,
    		String telefono, String region, String comuna) {
    	this.id = id;
    	this.nombre = nombre;
    	this.apellido = apellido; 
    	this.correo = correo;
    	this.fechaNacimiento = fechaNacimiento;
    	this.telefono = telefono;
    	this.region = region;
    	this.comuna = comuna;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
    
    

}
