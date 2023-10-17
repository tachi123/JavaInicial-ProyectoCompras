package com.curso.compras.models;

public class DescuentoFijo extends Descuento{

	@Override
	public double valorFinal(double valorInicial) {
		return valorInicial - this.getValorDescuento();
	}

}
