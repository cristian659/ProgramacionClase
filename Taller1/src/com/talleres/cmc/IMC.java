package com.talleres.cmc;

public class IMC {
	
	private int peso;
	private double estatura;
	private double imc;
	
	
	
	public IMC(int peso, double estatura) {
		super();
		this.peso = peso;
		this.estatura = estatura;
	}
	public IMC() {
		
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	}
	@Override
	public String toString() {
		return "IMC [peso=" + peso + ", estatura=" + estatura + "]";
	}
	
	public double Calcular(int peso, double estatura) {
		return imc = peso/Math.pow(estatura, 2);
	}
	

}
