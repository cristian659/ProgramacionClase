package com.Test.cmc;

import java.util.Scanner;

import com.talleres.cmc.IMC;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IMC imc;
		
		imc = new IMC();
		
		Scanner lectura = new Scanner (System.in);
		
		System.out.println("Ingrese su peso: ");
		int peso = lectura.nextInt();
		
		System.out.println("Ingrese su altura: ");
		double estatura = lectura.nextDouble();
		
		imc.Calcular(peso, estatura);
		
		System.out.println("Su indice de masa corporal el: "+ imc.getImc());
		
	}

}
