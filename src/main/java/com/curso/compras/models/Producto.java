package com.curso.compras.models;

import java.time.LocalDate;
import java.util.Objects;

public class Producto{

	private String nombre;
	private String descripcion;
	private LocalDate fechaAlta;
	private Integer pesoKg;
	private Double precio;
	private Integer stock;
	
	private static final Double minPrecio = 0.1;
	private static final Integer minStock = 10;
	
	public Producto(String nombre) {
		this.setNombre(nombre);
		this.setFechaAlta(LocalDate.now());
		this.setPrecio(minPrecio);
		this.setStock(minStock);
	}
	
	public Producto(String nombre, Double precio) {
		this.setNombre(nombre);
		this.setFechaAlta(LocalDate.now());
		this.setPrecio(precio);
		this.setStock(minStock);
	}
	
	public Producto(String nombre, String descripcion, Integer pesoKg, Double precio) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setPesoKg(pesoKg);
		this.setPrecio(precio);
		this.setFechaAlta(LocalDate.now());
		this.setStock(minStock);
	}
	
	@Override
	public String toString() {
		return this.getNombre()+" ("+this.getPrecio()+")";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre, precio);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		
		Producto otro = (Producto) obj;
		if(this.hashCode() == otro.hashCode())
			return true;
		else
			return false;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Integer getPesoKg() {
		return pesoKg;
	}
	public void setPesoKg(Integer pesoKg) {
		this.pesoKg = pesoKg;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public static Double getMinprecio() {
		return minPrecio;
	}
	public static Integer getMinstock() {
		return minStock;
	}
	
	
	
}
