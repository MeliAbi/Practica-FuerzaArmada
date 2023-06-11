package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public class Tanque extends Vehiculo implements Terrestre{

	private Double peso;
	
	public Tanque(String codigo, String modelo) {
		super(codigo, modelo);
		this.peso=100.0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void avanzar() {
		// TODO Auto-generated method stub
		System.out.println("Tanque Avanza");
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	
}
