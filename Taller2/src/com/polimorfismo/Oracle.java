package com.polimorfismo;

public class Oracle implements Operaciones {

	@Override public void conectar() {
		System.out.println("Conectado desde Oracle");
	}
	
	@Override public void consultar() {
		System.out.println("consultar desde Oracle");
	}
	@Override public void insertar() {
		System.out.println("insertar desde Oracle");
	}
	@Override public void eliminar() {
		System.out.println("eliminar desde Oracle");
	}
}
