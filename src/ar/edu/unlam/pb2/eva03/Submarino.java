package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public class Submarino extends Vehiculo implements Acuatico{

	private Double profundidad;
	
	public Submarino(String codigo, String modelo) {
		super(codigo, modelo);
		this.profundidad=0.0;
		// TODO Auto-generated constructor stub
	}

	public Double getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}

	@Override
	public void flotar() {
		// TODO Auto-generated method stub
		System.out.println("Florando :D");
		
	}

	
	
}
