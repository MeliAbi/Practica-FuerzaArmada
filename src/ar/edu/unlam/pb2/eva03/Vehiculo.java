package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public abstract class Vehiculo {
	protected String codigo="";
	private String modelo="";
	private Double velocidad;
	
	public Vehiculo (String codigo, String modelo){
		this.codigo = codigo;
		this.modelo = modelo;
		this.velocidad = 0.0;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Double velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vehiculo))
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public String toString() {
		String mensaje= "Codigo: "+this.codigo + "Modelo: " + this.modelo;
				return mensaje;
	}
	
}
