package com.polimorfismo;

public class BDatos implements Operaciones{
	@Override public void conectar() {
		System.out.println("Conectado desde la clase abstracta");
	}
	
	@Override public void consultar() {
		System.out.println("consultar desde la clase abstracta");
	}
	@Override public void insertar() {
		System.out.println("insertar desde la clase abstracta");
	}
	@Override public void eliminar() {
		System.out.println("eliminar desde la clase abstracta");
	}
	
}
