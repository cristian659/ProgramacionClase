package com.test;

import com.polimorfismo.Operaciones;
import com.polimorfismo.Oracle;
import com.polimorfismo.Postgres;

public class test_polimorfismo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Operaciones Oracle = new Oracle();
		Oracle.conectar();
		Oracle.consultar();
		Oracle.insertar();
		Oracle.eliminar();
		
		System.out.println("\n ------------------------------ \n");
		Operaciones Postgres = new Postgres();
		Postgres.conectar();
		Postgres.consultar();
		Postgres.insertar();
		Postgres.eliminar();

	}

}
