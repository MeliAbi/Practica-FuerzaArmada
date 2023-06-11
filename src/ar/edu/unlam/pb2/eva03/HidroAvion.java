package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public class HidroAvion extends Vehiculo implements Volador,Acuatico{

	private Double altura;
	private Double profundidad;
	
	public HidroAvion(String codigo, String modelo) {
		super(codigo, modelo);
		this.altura=0.0;
		this.profundidad=0.0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void flotar() {
		// TODO Auto-generated method stub
		System.out.println("HidroAvion Flotando");
	}

	@Override
	public void despegar() {
		// TODO Auto-generated method stub
		System.out.println("HidroAvion Despegando");
	}

	@Override
	public void volar() {
		// TODO Auto-generated method stub
		System.out.println("HidroAvion Volando");
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}
	


}
