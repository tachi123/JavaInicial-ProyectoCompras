package com.curso.compras;

import java.util.HashSet;
import java.util.Set;

import com.curso.compras.excepciones.*;
import com.curso.compras.models.*;

public class App 
{
    public static void main( String[] args )
    {    	
    	//Instancio una persona
    	Persona unaPersona = new Persona("Nahuel","Ramírez");
    	
    	//Creamos descuentos
    	DescuentoFijo desc1 = new DescuentoFijo();
    	desc1.setValorDescuento(500);
    	DescuentoPorcentaje desc2 = new DescuentoPorcentaje();
    	desc2.setValorDescuento(0.3); //Descuento del 30%
    	
    	//Instanciar 3 productos
    	Producto harina = new Producto("harina",2000.0);
    	Producto roastBeef = new Producto("Roast beef",1250.5);
    	Producto leche = new Producto("leche",250.0);
    	
    	//Instancio 3 items carritos
    	ItemCarrito item1 = new ItemCarrito(harina,2);
    	ItemCarrito item2 = new ItemCarrito(roastBeef, 1);
    	ItemCarrito item3 = new ItemCarrito(leche,3);
    	
    	//Creo un carrito
    	Carrito unCarrito = new Carrito(unaPersona);
    	
    	unCarrito.agregarItem(item1); //Agregó 3 productos de harina
    	unCarrito.agregarItem(item2); //Agregó 1 producto RoastBeef
    	unCarrito.agregarItem(item3); //Agregó 3 leches    	
    	
    	//Creo otro carrito
    	Carrito otroCarrito = new Carrito(unaPersona);
    	//Pero al agregar items a la lista que me devuelve el método getItems
    	//lo hago en una colección que es una copia
    	//entonces, no estoy modificando la lista original de la instancia
    	otroCarrito.getItems().addAll(unCarrito.getItems());
    
    	try {
	    	System.out.println("Costo final del carrito sin descuento: "+unCarrito.getCostoFinal());
	    	System.out.println("Costo final del carrito con descuento fijo: "+unCarrito.getCostoFinal(desc1));
	    	System.out.println("Costo final del carrito con descuento con pocentaje: "+unCarrito.getCostoFinal(desc2));
	    } catch (NoHayStockException e) {
    		System.out.println("No hay stock del producto: "+e.getProducto().getNombre());
    	} catch (NoSuperoMontoMinException e) {
    		System.out.println("No se supero el monto mínimio necesario para compras ($5000)");
    	} finally {
    		System.out.println("Salio todo bien");
    	}
    	
    	System.out.println("Sigue andando?");
    	
    	Set<Producto> productosDistintos = new HashSet<Producto>();
    	
    	Producto harina1 = new Producto("harina",2000.0);
    	
    	productosDistintos.add(leche);
    	productosDistintos.add(harina);
    	productosDistintos.add(harina1);
    	
    	System.out.println(productosDistintos);
    	
    }
}
