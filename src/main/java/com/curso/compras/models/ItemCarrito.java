package com.curso.compras.models;

import com.curso.compras.excepciones.NoHayStockException;

public class ItemCarrito {
	
	private Producto producto;
	private Integer cantidad;
	
	public ItemCarrito(Producto producto, Integer cantidad) {
		this.setCantidad(cantidad);
		this.setProducto(producto);
	}
	
	public double getPrecio() throws NoHayStockException{
		//VALIDAMOS NO HAY STOCK
		if(this.getProducto().getStock() < this.getCantidad()) {
			throw new NoHayStockException(this.getProducto());
		}		
		return this.producto.getPrecio()*this.getCantidad();
	}
	
	public String toString() {
		return this.getProducto().getNombre() + " ("+this.getCantidad()+")"; 
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
