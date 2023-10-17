package com.curso.compras.models;

public abstract class Descuento {

	private double valor;
	
	public double getValorDescuento() {
		return valor;
	}
	
	public void setValorDescuento(double valor) {
		this.valor = valor;
	}
	
	public abstract double valorFinal(double valorInicial);
	
}
