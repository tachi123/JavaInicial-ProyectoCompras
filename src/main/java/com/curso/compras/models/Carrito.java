package com.curso.compras.models;

import java.util.ArrayList;
import java.util.List;

import com.curso.compras.excepciones.NoHayStockException;
import com.curso.compras.excepciones.NoSuperoMontoMinException;

public class Carrito {

	private Persona persona;
	private List<ItemCarrito> items;
	
	public Carrito() {
		//Cada instancia de esta clase, va a tener asociado una lista de Items
		this.items = new ArrayList<ItemCarrito>();
	}
	
	public Carrito(Persona persona) {
		this.items = new ArrayList<ItemCarrito>();
		this.setPersona(persona);
	}
	
	//Si no queremos dar acceso directo a la lista de items de la instancia
	//retornamos una copia
	public List<ItemCarrito> getItems(){
		List<ItemCarrito> items1 = new ArrayList<ItemCarrito>();
		items1.addAll(this.items);
		return items1;
	}
	
	public void agregarItem(ItemCarrito ic) {
		this.items.add(ic);
	}
	
	public void quitarItem(ItemCarrito ic) {
		this.items.remove(ic);
	}
		
	public Double getCostoFinal() throws NoHayStockException, NoSuperoMontoMinException{
		Double costoFinal = 0.0; //variable de acumulación
		
		//Trabajo similar a un array
		for(ItemCarrito item : this.items) {
			costoFinal = costoFinal + item.getProducto().getPrecio()*item.getCantidad();
		}
		
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
	
}
