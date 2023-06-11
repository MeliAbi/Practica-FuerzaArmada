package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public class Anfibio extends Vehiculo implements Acuatico, Terrestre{

	private Double profundidad;
	
	public Anfibio(String codigo, String modelo) {
		super(codigo, modelo);
		this.profundidad=0.0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void avanzar() {
		// TODO Auto-generated method stub
		System.out.println("Anfibio avanza");
	}

	@Override
	public void flotar() {
		// TODO Auto-generated method stub
		System.out.println("Anfibio Flota");
	}

	public Double getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}

	

}
