package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class FuerzaArmada {

	private Set<Vehiculo> convoy;
	private Map<String, Batalla> batallas;

	private Set<Terrestre> convoyTerrestre;
	private Set<Volador> convoyVolador;
	private Set<Acuatico> convoyAcuatico;

	private String nombre="";

	public FuerzaArmada(String nombre) {
		this.nombre=nombre;
		convoy= new LinkedHashSet<Vehiculo>();
		convoyTerrestre= new HashSet<Terrestre>();
		convoyVolador= new HashSet<Volador>();
		convoyAcuatico= new HashSet<Acuatico>();
		batallas = new TreeMap<String, Batalla>();

	}

	public void crearBatalla(String nombre, Batalla nuevaBatalla) {
		batallas.put(nombre, nuevaBatalla);
	}


	public void agregarVehiculo(Vehiculo nuevo) {
		convoy.add(nuevo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapacidadDeDefensa() {
		return convoy.size();
	}

	public Set<Vehiculo> getConvoy() {
		return convoy;
	}

	public void setConvoy(Set<Vehiculo> convoy) {
		this.convoy = convoy;
	}

	public String toString () {
		String mensaje = "";

		for(Vehiculo actual:convoy) {
			mensaje += " Codigo: " + actual.getCodigo() + "\n";
		}

		return mensaje;
	}

	public void mostrarBatallas () {
		System.out.println(batallas);

	}
	public Map<String, Batalla> getBatallas() {
		return batallas;
	}

	public void setBatallas(Map<String, Batalla> batallas) {
		this.batallas = batallas;
	}

	public Vehiculo buscarVehiculoEnConvoy(String codVehiculo) throws VehiculoInexistente{

		Vehiculo nuevo = null;

		for (Vehiculo actual : convoy) {
			if (actual.getCodigo().equals(codVehiculo)) {
				nuevo=actual;
			}
		}
			if(nuevo!=null) {
				
				if(nuevo instanceof Avion) {
					return ((Avion)nuevo);
					
				}else if(nuevo instanceof HidroAvion) {
					return ((HidroAvion)nuevo);

				}else if(nuevo instanceof Submarino) {
					return ((Submarino)nuevo);

				}else if(nuevo instanceof Anfibio) {
					return ((Anfibio)nuevo);

				}else if(nuevo instanceof Tanque) {
					return ((Tanque)nuevo);

				}
			}else {
				throw new VehiculoInexistente("El vehículo con código " + codVehiculo + " no existe en el convoy.");
			}
			
		return nuevo;

	}

	public Boolean queCoincidaTipoDeBatalla(String nomBatalla, Vehiculo nuevo)throws VehiculoIncompatible {

		//		if(nuevo instanceof Volador && batallas.get(nomBatalla).getTipo().equals(TipoDeBatalla.VOLADOR)) {
		//			return true;
		//		}else if(nuevo instanceof Terrestre && batallas.get(nomBatalla).getTipo().equals(TipoDeBatalla.TERRESTRE)) {
		//			return true;
		//		}else if(nuevo instanceof Acuatico && batallas.get(nomBatalla).getTipo().equals(TipoDeBatalla.ACUATICO)) {
		//			return true;
		//		}
		Boolean a=false;
		if((nuevo instanceof Avion || nuevo instanceof HidroAvion ) && batallas.get(nomBatalla).getTipo().equals(TipoDeBatalla.VOLADOR)) {
			return a;
		}else if((nuevo instanceof Tanque || nuevo instanceof Anfibio )  && batallas.get(nomBatalla).getTipo().equals(TipoDeBatalla.TERRESTRE)) {
			return a;
		}else if((nuevo instanceof Submarino || nuevo instanceof HidroAvion || nuevo instanceof Anfibio) && batallas.get(nomBatalla).getTipo().equals(TipoDeBatalla.ACUATICO)) {
			return a;
		}else if (a==false) {
			throw new VehiculoIncompatible("Tipos incompatibles");
		}
		return a;
	}

	public Boolean enviarALaBatalla(String nomBatalla, String codVehiculo) {

		Vehiculo nuevo = null;
		try {
		nuevo=buscarVehiculoEnConvoy(codVehiculo);
		}
		catch (VehiculoInexistente e) {
			System.out.println("Error: "+ e.getMessage());
		}
		
		try {
			if(batallas.containsKey(nomBatalla) && nuevo!=null && queCoincidaTipoDeBatalla(nomBatalla,nuevo)) {
				
				Batalla nuevaBatalla=batallas.get(nomBatalla);
				nuevaBatalla.agregarVehiculosEnLaBatalla(nuevo);
				
				return true;
			}
		} catch (VehiculoIncompatible e) {
			e.getMessage();
		}
		return false;
	}
}
