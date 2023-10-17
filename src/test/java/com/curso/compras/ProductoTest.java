package com.curso.compras;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.curso.compras.models.Producto;

public class ProductoTest {

	@Test
	public void validadQueDosProductosSonIguales(){
		
		Producto harina = new Producto("harina",100.0);
		Producto harina1 = new Producto("harina",100.0);
		
		assertTrue(harina.equals(harina1));
	}
}
