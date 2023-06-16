package ar.edu.unlam.pb2.eva03;

import static org.junit.Assert.*;

import org.junit.Test;

//import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBatalla;
//HOLIII
public class TestCases {

	@Test
	public void queSePuedaCrearUnObjetoVolador() {
		//Vehiculo avion = new Volador();
		Vehiculo avion = new Avion("1", "A-10");
		((Avion)avion).setAltura(1.0);
		
		//assertEquals(1.0, ((Avion) avion).getAltura());
		assertEquals(1.0, ((Avion) avion).getAltura(), 0.01);
		((Volador)avion).volar();
		//assertEquals(,);
	}
	
	@Test
	public void queSePuedaCrearUnObjetoTerrestre() {
		//Vehiculo tanque = new Terrestre();
		Vehiculo tanque = new Tanque("5", "Renault FT");

		//assertEquals(0.0, tanque.getVelocidad());
		((Terrestre)tanque).avanzar();
		assertEquals(0.0, tanque.getVelocidad(), 0.1);
	}
	
	@Test
	public void queSePuedaCrearUnObjetoAcuatico() {
		//Vehiculo submarino = new Acuatico();
		Vehiculo submarino = new Submarino("5", "ARA - San Juan");

		//assertEquals(0.0, submarino.getProfundidad());
		((Acuatico)submarino).flotar();
		assertEquals(0.0, ((Submarino)submarino).getProfundidad(), 0.01);
	}
	
	@Test
	public void queSePuedaCrearUnObjetoAnfibio() {
		//Vehiculo var = new Anfibio();
		Vehiculo sapo = new Anfibio("5", "LARC-5");

		//assertEquals(0.0, var.getVelocidad());
		//assertEquals(0.0, var.getProfundidad());
		((Acuatico)sapo).flotar();
		((Terrestre)sapo).avanzar();
		assertEquals(0.0, sapo.getVelocidad(), 0.01);
		assertEquals(0.0, ((Anfibio)sapo).getProfundidad(), 0.01);
	}
	
	@Test
	public void queSePuedaCrearUnHidroavion() {
		Vehiculo ag600 = new HidroAvion("5", "AG600");
		
		((HidroAvion)ag600).setAltura(123.00);

		assertEquals(123.00, ((HidroAvion)ag600).getAltura(), 0.01);
		assertEquals(0.0, ((HidroAvion)ag600).getProfundidad(), 0.01);
		
		((HidroAvion)ag600).volar();
		((Volador)ag600).volar();
	}
	
	@Test
	public void queSePuedaArmarElConvoy() {  	//Permite repeticion entre diferentes tipos objetos
		FuerzaArmada argentina = new FuerzaArmada("SAN MARTIN");

		argentina.agregarVehiculo(new Avion("0001", "A-10"));
		argentina.agregarVehiculo(new Avion("0002", "A-10"));
		argentina.agregarVehiculo(new Avion("0003", "F-102"));
		argentina.agregarVehiculo(new Avion("0004", "F-15"));
		argentina.agregarVehiculo(new Tanque("0005", "Renault FT"));
		argentina.agregarVehiculo(new Tanque("0006", "T-72"));
		argentina.agregarVehiculo(new Tanque("0007", "T-72"));
		argentina.agregarVehiculo(new Submarino("0008", "A-10"));
		argentina.agregarVehiculo(new Portaviones("0009", "A-10"));
		argentina.agregarVehiculo(new Avion("0010", "A-10"));
		argentina.agregarVehiculo(new Avion("0011", "A-10"));
		argentina.agregarVehiculo(new HidroAvion("0012", "A-10"));
		argentina.agregarVehiculo(new Anfibio("0012", "A-10"));
		argentina.agregarVehiculo(new Anfibio("0012", "A-10"));

		System.out.println(argentina.toString());
		
		//assertEquals(12, argentina.getCapacidadDeDefensa());
		assertEquals((Integer)12, argentina.getCapacidadDeDefensa());
		
	}
	
	@Test
	public void queSePuedaCrearUnaBatalla() {
		FuerzaArmada argentina = new FuerzaArmada("SAN MARTIN");

		Batalla nuevaBatalla = new Batalla(TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		
		argentina.crearBatalla("San Lorenzo", nuevaBatalla);
		//argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		argentina.mostrarBatallas();
		assertEquals(true, argentina.getBatallas().containsValue(nuevaBatalla));
		assertEquals(1, argentina.getBatallas().size());

	}	
	
	@Test
	public void queSePuedaPlanearLaBatallaSobreElOceano() {
		FuerzaArmada argentina = new FuerzaArmada("SAN MARTIN");
		String key = "San Lorenzo";
		
		Batalla nuevaBatalla = new Batalla(TipoDeBatalla.ACUATICO, 100.5, 20.3);
		argentina.crearBatalla(key,nuevaBatalla);
		
		assertTrue(argentina.getBatallas().containsKey(key)); 					//Devuelve true si existe
		assertEquals(20.3, argentina.getBatallas().get(key).getLatitud(),0.01); //Devuelve objeto con ese key
		assertEquals(TipoDeBatalla.ACUATICO, argentina.getBatallas().get(key).getTipo());
	}
	
	@Test
	public void queSePuedaPresentarBatallaTerrestre() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada("SAN MARTIN");

		argentina.agregarVehiculo(new Avion("0001", "A-10"));
		argentina.agregarVehiculo(new Avion("0002", "A-10"));
		argentina.agregarVehiculo(new Avion("0003", "F-102"));
		Vehiculo nuevoVehiculo2 = new Avion("0004", "F-15");
		argentina.agregarVehiculo(nuevoVehiculo2);
		Vehiculo nuevoVehiculo = new Tanque("0005", "Renault FT");
		argentina.agregarVehiculo(nuevoVehiculo);
		argentina.agregarVehiculo(new Tanque("0006", "T-72"));
		argentina.agregarVehiculo(new Tanque("0007", "T-72"));
		argentina.agregarVehiculo(new Submarino("0008", "A-10"));
		argentina.agregarVehiculo(new Portaviones("0009", "A-10"));
		argentina.agregarVehiculo(new Avion("0010", "A-10"));
		argentina.agregarVehiculo(new Avion("0011", "A-10"));
		argentina.agregarVehiculo(new Anfibio("0012", "A-10"));
		argentina.agregarVehiculo(new HidroAvion("0012", "A-10"));
		
		
		assertEquals((Integer)12, argentina.getCapacidadDeDefensa());
		Batalla nuevaBatalla = new Batalla(TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		argentina.crearBatalla("San Lorenzo",nuevaBatalla);

		
		//argentina.presentarBatalla(); // ¿MOSTRAR DATOS DE BATALLA? (mostrarBatalla())
		//argentina.mostrarBatallas();
		
		assertNotNull(argentina.buscarVehiculoEnConvoy("0007"));

		assertTrue(argentina.queCoincidaTipoDeBatalla("San Lorenzo", nuevoVehiculo));
		
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", "0012"));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", "0006"));
		assertFalse(argentina.enviarALaBatalla("San Lorenzo", "0008"));			
	}
	
	@Test (expected = VehiculoInexistente.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoExista()  throws VehiculoInexistente, VehiculoIncompatible{
		FuerzaArmada argentina = new FuerzaArmada("San Martin");

		argentina.agregarVehiculo(new Tanque("005", "Renault FT"));
		argentina.agregarVehiculo(new Tanque("006", "T-72"));
		argentina.agregarVehiculo(new Tanque("007", "T-72"));
		argentina.agregarVehiculo(new Avion("0011", "A-10"));
		Batalla nuevaBatalla = new Batalla(TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		argentina.crearBatalla("San Lorenzo", nuevaBatalla);

		assertTrue(argentina.enviarALaBatalla("San Lorenzo", "005"));
		assertFalse(argentina.enviarALaBatalla("San Lorenzo", "004"));
		assertFalse(argentina.enviarALaBatalla("San Lorenzo", "0011"));
	}
	
	@Test (expected = VehiculoIncompatible.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoSeaCompatible()  throws VehiculoInexistente, VehiculoIncompatible{
		FuerzaArmada argentina = new FuerzaArmada("San Martin");

		argentina.agregarVehiculo(new Tanque("005", "Renault FT"));
		argentina.agregarVehiculo(new Tanque("006", "T-72"));
		argentina.agregarVehiculo(new Tanque("007", "T-72"));
		argentina.agregarVehiculo(new Avion("0011", "A-10"));
		Batalla nuevaBatalla = new Batalla(TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		argentina.crearBatalla("San Lorenzo", nuevaBatalla);
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", "005"));
		assertFalse(argentina.enviarALaBatalla("San Lorenzo", "0011"));
		assertFalse(argentina.enviarALaBatalla("San Lorenzo", "004"));
	}
}
	/*

	@Test
	public void queSePuedaPresentarBatallaNaval() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));

		assertEquals(12, argentina.getCapacidadDeDefensa());
		argentina.crearBatalla("Pacifico", TipoDeBatalla.NAVAL, 200.5, 45.8);

		assertTrue(argentina.enviarALaBatalla("Pacifico", 8));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 9));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 10));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 11));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 12));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 13));		
	}

	@Test (expected = VehiculoIncompatible.class)
	public void queSeNoSePuedaEnviarAUnaBatallaEnTierraUnBarco() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertFalse(argentina.enviarALaBatalla("San Lorenzo", 11));

	}

}
*/
