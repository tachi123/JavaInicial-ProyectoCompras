package com.curso.compras.models;

public class Persona{

	private String nombre;
	private String apellido;
	
	public Persona() {}
	
	public Persona(String nombre, String apellido) {
		this.setApellido(apellido);
		this.setNombre(nombre);
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
	
	
	
	
}
