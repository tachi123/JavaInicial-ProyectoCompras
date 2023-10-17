package com.curso.compras;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.curso.compras.excepciones.NoHayStockException;
import com.curso.compras.models.*;

public class CarritoTest {

	@Test
	public void validarCostoFinalSinDescuentoUsandoIterator() {
		
		//Instancio una persona
    	Persona unaPersona = new Persona("Nahuel","Ramírez");
    	
    	//Creamos descuentos
    	DescuentoFijo desc1 = new DescuentoFijo();
    	desc1.setValorDescuento(500);
    	DescuentoPorcentaje desc2 = new DescuentoPorcentaje();
    	desc2.setValorDescuento(0.3); //Descuento del 30%
    	
    	//Instanciar 3 productos
    	Producto harina = new Producto("harina",100.0);
    	Producto roastBeef = new Producto("Roast beef",1250.5);
    	Producto leche = new Producto("leche",250.0);
    	
    	//Instancio 3 items carritos
    	ItemCarrito item1 = new ItemCarrito(harina,3);
    	ItemCarrito item2 = new ItemCarrito(roastBeef, 1);
    	ItemCarrito item3 = new ItemCarrito(leche,3);
    	
    	//Creo un carrito
    	Carrito unCarrito = new Carrito(unaPersona);
    	
    	unCarrito.agregarItem(item1);
    	unCarrito.agregarItem(item2);
    	unCarrito.agregarItem(item3);
    	
    	Double costoFinalDelCarritoUsandoIterator = 0.0;
    			
		try {
	    	Iterator<ItemCarrito> iterador = unCarrito.getItems().iterator();
	    	while( iterador.hasNext()) {
	    		ItemCarrito item = iterador.next();
	    		costoFinalDelCarritoUsandoIterator = costoFinalDelCarritoUsandoIterator + item.getPrecio();
	    	}    
			assertEquals(unCarrito.getCostoFinal(), costoFinalDelCarritoUsandoIterator);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	@Test
	public void validarCostoFinalSinDescuentoUsandoStream() {
		
		//Instancio una persona
    	Persona unaPersona = new Persona("Nahuel","Ramírez");
    	
    	//Creamos descuentos
    	DescuentoFijo desc1 = new DescuentoFijo();
    	desc1.setValorDescuento(500);
    	DescuentoPorcentaje desc2 = new DescuentoPorcentaje();
    	desc2.setValorDescuento(0.3); //Descuento del 30%
    	
    	//Instanciar 3 productos
    	Producto harina = new Producto("harina",100.0);
    	Producto roastBeef = new Producto("Roast beef",1250.5);
    	Producto leche = new Producto("leche",250.0);
    	
    	//Instancio 3 items carritos
    	ItemCarrito item1 = new ItemCarrito(harina,3);
    	ItemCarrito item2 = new ItemCarrito(roastBeef, 1);
    	ItemCarrito item3 = new ItemCarrito(leche,3);
    	
    	//Creo un carrito
    	Carrito unCarrito = new Carrito(unaPersona);
    	
    	unCarrito.agregarItem(item1);
    	unCarrito.agregarItem(item2);
    	unCarrito.agregarItem(item3);
    	
    	Double costoFinalDelCarritoUsandoStream = 0.0;
    			
		try {
	    	costoFinalDelCarritoUsandoStream =
	    			unCarrito.getItems().stream()
	    			.mapToDouble(item -> item.getProducto().getPrecio()).sum();	    			
			
			assertEquals(unCarrito.getCostoFinal(), costoFinalDelCarritoUsandoStream);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
}
