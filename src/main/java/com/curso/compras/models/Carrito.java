package com.curso.compras.models;

import com.curso.compras.excepciones.NoHayStockException;
import com.curso.compras.excepciones.NoSuperoMontoMinException;

public class Carrito {

	private Persona persona;
	private ItemCarrito item1;
	private ItemCarrito item2;
	private ItemCarrito item3;
	
	public Carrito() {};
	
	public Carrito(Persona persona) {
		this.setPersona(persona);
	}	
	
	public Double getCostoFinal() throws NoHayStockException, NoSuperoMontoMinException{
		Double costoFinal = 0.0; //variable de acumulación
		costoFinal = this.item1.getPrecio() + this.item2.getPrecio() + this.item3.getPrecio();	
		
		//Si no supera 5000, no puede comprar
		if(costoFinal < 5000) {
			throw new NoSuperoMontoMinException();
		}
		
		return costoFinal;
	}
	
	public Double getCostoFinal(Descuento desc) throws NoHayStockException, NoSuperoMontoMinException{
		return desc.valorFinal(this.getCostoFinal());
	}
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public ItemCarrito getItem1() {
		return item1;
	}
	public void setItem1(ItemCarrito item1) {
		this.item1 = item1;
	}
	public ItemCarrito getItem2() {
		return item2;
	}
	public void setItem2(ItemCarrito item2) {
		this.item2 = item2;
	}
	public ItemCarrito getItem3() {
		return item3;
	}
	public void setItem3(ItemCarrito item3) {
		this.item3 = item3;
	}
	
	
	
	
}
