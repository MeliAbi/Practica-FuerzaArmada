package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public class Avion extends Vehiculo implements Volador {

	private Double altura;
	
	public Avion(String codigo, String modelo) {
		super(codigo, modelo);
		this.altura=0.0;
	}

	@Override
	public void despegar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volar() {
		// TODO Auto-generated method stub
		System.out.println("Avion volando");
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	
	
	public String toString () {
		String mensaje = getCodigo();
		
		return mensaje;
	}
	
	

}
