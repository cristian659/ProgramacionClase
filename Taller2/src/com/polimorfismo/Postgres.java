package com.polimorfismo;

public class Postgres implements Operaciones{

	@Override public void conectar() {
		System.out.println("Conectado desde Postgres");
	}
	
	@Override public void consultar() {
		System.out.println("consultar desde Postgres");
	}
	@Override public void insertar() {
		System.out.println("insertar desde Postgres");
	}
	@Override public void eliminar() {
		System.out.println("eliminar desde Postgres");
	}
}
