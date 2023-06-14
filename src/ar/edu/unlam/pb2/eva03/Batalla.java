package ar.edu.unlam.pb2.eva03;

import java.util.Set;
import java.util.HashSet;

/*
import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBatalla;
import ar.edu.unlam.pb2.eva03.excepciones.VehiculoIncompatible; ///////////
import ar.edu.unlam.pb2.eva03.interfaces.Acuatico;
import ar.edu.unlam.pb2.eva03.interfaces.Terrestre;
import ar.edu.unlam.pb2.eva03.interfaces.Volador;
*/

public class Batalla {
	
	private Double latitud=0.0;
	private Double longitud=0.0;
	private TipoDeBatalla tipo=null;
	private Set<Vehiculo> vehiculosEnLaBatalla;
	
	public Batalla (TipoDeBatalla tipo, Double longitud, Double latitud) {
		this.latitud=latitud;
		this.tipo=tipo;
		this.longitud=longitud;
		vehiculosEnLaBatalla = new HashSet<Vehiculo>();
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public TipoDeBatalla getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeBatalla tipo) {
		this.tipo = tipo;
	}
	

	public Set<Vehiculo> getVehiculosEnLaBatalla() {
		return vehiculosEnLaBatalla;
	}

	public void setVehiculosEnLaBatalla(Set<Vehiculo> vehiculosEnLaBatalla) {
		this.vehiculosEnLaBatalla = vehiculosEnLaBatalla;
	}

	public void agregarVehiculosEnLaBatalla(Vehiculo vehiculo) {

		vehiculosEnLaBatalla.add(vehiculo);
		
	}

	public String toString () {
		String mensaje= "Latitud: " + getLatitud() + "\n" +
						"Longitud: " + getLongitud() + "\n" +
						"Tipo: " + getTipo() + "\n";
		
		return mensaje;
	}
	
}
