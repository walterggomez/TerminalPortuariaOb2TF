package TerminalPortuaria.Ob2TF.EstrategiaMejorRutaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Circuito.Tramo;
import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.MenorCantidadTerminal;
import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.MenorPrecio;
import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.MenorTiempo;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class MejorRutaTest {
	
	MenorPrecio mejorRuta1;
	MenorCantidadTerminal mejorRuta2;
	MenorTiempo mejorRuta3;

	TerminalPortuaria bsAs;
	TerminalPortuaria saoPablo;
	TerminalPortuaria busan;
	TerminalPortuaria hongKong;
	TerminalPortuaria cartagena;
	TerminalPortuaria shanghai;
	TerminalPortuaria singapur;
	TerminalPortuaria longBeach;
	
	Naviera naviera1; // [circuito1, circuito2]
	Naviera naviera2; // [circuito3]

	Circuito circuito1; // [tramo1,tramo2,tramo3]-> bsAs - saoPablo - busan - hongKong
						//                               1d         5d       2d        = 8d  
	Circuito circuito2; // [tramo4,tramo5,tramo6]-> bsAs - cartagena - shanghai - singapur
						//                               3d           5d         1d    = 9d   
	Circuito circuito3; // [tramo7,tramo8,tramo9]-> bsAs - longBeach - saoPablo - cartagena
						//                               5d          4d          1     = 10d    	
	
	Tramo tramo1; // bsAs-saoPablo
	Tramo tramo2; // saoPablo-busan
	Tramo tramo3; // busan-hongKong
	
	Tramo tramo4; // bsAs-cartagena
	Tramo tramo5; // cartagena-shanghai
	Tramo tramo6; // shanghai-singapur
	
	Tramo tramo7; // bsAs-longBeach
	Tramo tramo8; // longBeach-saoPablo
	Tramo tramo9; // saoPablo-cartagena
	
	List<Naviera> navieras;

	List<Circuito> circuitosN1;
	List<Circuito> circuitosN2;
	List<Circuito> circuitosN3;

	List<Circuito> todoCircuito;
	
	List<Tramo> tramosCir1;
	List<Tramo> tramosCir2;
	List<Tramo> tramosCir3;
	

	@BeforeEach
	void setUp() throws Exception {
		// Estrategia 
		mejorRuta1 = new MenorPrecio();
		mejorRuta2 = new MenorCantidadTerminal();
		mejorRuta3 = new MenorTiempo();
		
		// TerminalPortuaria
		bsAs = mock(TerminalPortuaria.class);
		saoPablo = mock(TerminalPortuaria.class);
		busan = mock(TerminalPortuaria.class);
		hongKong = mock(TerminalPortuaria.class);
		cartagena = mock(TerminalPortuaria.class);
		shanghai = mock(TerminalPortuaria.class);
		singapur = mock(TerminalPortuaria.class);
		longBeach = mock(TerminalPortuaria.class);
		
		//Naviera		
		naviera1 = mock(Naviera.class);
		naviera2 = mock(Naviera.class);
		
		//Circuito
		circuito1 = mock(Circuito.class);
		circuito2 = mock(Circuito.class);
		circuito3 = mock(Circuito.class);
		
		//Tramo
		tramo1 = mock(Tramo.class);
		tramo2 = mock(Tramo.class);
		tramo3 = mock(Tramo.class);
		tramo4 = mock(Tramo.class);
		tramo5 = mock(Tramo.class);
		tramo6 = mock(Tramo.class);
		tramo7 = mock(Tramo.class);
		
		
		// Lista de Navieras
		navieras = Arrays.asList(naviera1, naviera2);
		
		// Lista de Circuitos
		circuitosN1 = Arrays.asList(circuito1, circuito2);
		circuitosN2 = Arrays.asList(circuito3); 
		
		todoCircuito = Arrays.asList(circuito1, circuito2, circuito3);
		
		// Lista de Tramos
		tramosCir1 = Arrays.asList(tramo1, tramo2,tramo3);
		tramosCir2 = Arrays.asList(tramo4, tramo5,tramo6);
		tramosCir3 = Arrays.asList(tramo7,tramo8,tramo9);
		
		// Set un valor Mockito
		when(bsAs.getMisNavieras()).thenReturn(navieras);
		when(naviera1.getMisCircuitos()).thenReturn(circuitosN1);
		when(naviera2.getMisCircuitos()).thenReturn(circuitosN2);
		
		when(circuito1.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(true);
		when(circuito2.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(true);
		when(circuito3.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(true);
		
		when(circuito1.validarSiTerminalExisteEnCircuito(saoPablo)).thenReturn(true);
		when(circuito1.validarSiTerminalExisteEnCircuito(busan)).thenReturn(true);
		when(circuito1.validarSiTerminalExisteEnCircuito(hongKong)).thenReturn(true);
		
		when(circuito2.validarSiTerminalExisteEnCircuito(cartagena)).thenReturn(true);
		when(circuito2.validarSiTerminalExisteEnCircuito(shanghai)).thenReturn(true);
		when(circuito2.validarSiTerminalExisteEnCircuito(singapur)).thenReturn(true);
		
		when(circuito3.validarSiTerminalExisteEnCircuito(longBeach)).thenReturn(true);
		when(circuito3.validarSiTerminalExisteEnCircuito(saoPablo)).thenReturn(true);
		when(circuito3.validarSiTerminalExisteEnCircuito(cartagena)).thenReturn(true);
		
		when(circuito1.costoTotalDelCircuito()).thenReturn(250.0);
		when(circuito2.costoTotalDelCircuito()).thenReturn(150.0);
		when(circuito3.costoTotalDelCircuito()).thenReturn(350.0);
		
		when(circuito1.duracionCircuito()).thenReturn((long) 8);
		when(circuito2.duracionCircuito()).thenReturn((long) 9);
		when(circuito3.duracionCircuito()).thenReturn((long) 10);
		
		//when(circuito1.cantidadDeEscalas()).thenReturn(0);// si el puerto destino es SaoPablo
		//when(circuito3.cantidadDeEscalas()).thenReturn(1);// si el puerto destino es SaoPablo
	
	}

	@Test
	void navierasDelPuertoTest() {
		assertEquals(navieras, mejorRuta1.navierasDelPuerto(bsAs));
	}

	@Test
	void todosLosCircuitosMaritimosTest() {
		assertEquals(todoCircuito, mejorRuta1.todosLosCircuitosMaritimos(navieras));

	}
	@Test
	void listaDeCircuitosTest() {
		List<Circuito> circuitosASaoPablo= Arrays.asList(circuito1,circuito3);
		assertEquals(circuitosASaoPablo, mejorRuta1.listaDeCircuitos(bsAs, saoPablo));
		List<Circuito> circuitosAShanghai= Arrays.asList(circuito2);
		assertEquals(circuitosAShanghai, mejorRuta1.listaDeCircuitos(bsAs, shanghai));
	}
	@Test
	void tieneMenorPrecioTest() {
		
		assertTrue(mejorRuta1.tieneMenorPrecio(circuito1, circuito3));
	}
	/*
    @Test
    void mejorCircuitoParaMenorCantidadDeEscalasTest() {
        assertEquals(circuito1, mejorRuta2.mejorCircuito(bsAs, saoPablo));
    }
    */
	@Test
	void tieneMenorTiempo() {
		assertTrue(mejorRuta3.tieneMenorTiempo(circuito2, circuito3));
	}
	@Test
	void mejorCircuitoParaMenorPrecioTest() {
		assertEquals(circuito1,mejorRuta1.mejorCircuito(bsAs, saoPablo));
	}
	
	/*
	@Test
	void mejorCircuitoParaMenorCantidadDeEscalasTest() {
		assertEquals(circuito1, mejorRuta2.mejorCircuito(bsAs, saoPablo));
	}
	*/
	
	@Test
	void mejorCircuitoParaMenorTiempoTest() {
		assertEquals(circuito2,mejorRuta3.mejorCircuito(bsAs, cartagena));
	}
	
	
    @Test // Testearlo con objetos reales para ver si el problema es con mockito
    void circuitoReducidoEntreMontevideoSantiagoDeChile()
    {
    	// Terminales
		TerminalPortuaria bsAs = new TerminalPortuaria( "Buenos Aires", new Point2D.Double(-34.61315, -58.37723) );
		TerminalPortuaria saoPablo = new TerminalPortuaria( "Sao Pablo", new Point2D.Double(-23.5475, -46.63611) );
		TerminalPortuaria montevideo = new TerminalPortuaria( "Montevideo", new Point2D.Double(-34.90328, -56.18816) );
		TerminalPortuaria asuncion = new TerminalPortuaria( "Asuncion", new Point2D.Double(-25.28646, -57.647) );
		TerminalPortuaria lima = new TerminalPortuaria( "Lima", new Point2D.Double(-12.04318, -77.02824) );
		TerminalPortuaria santiagoDeChile = new TerminalPortuaria( "Santiago de Chile", new Point2D.Double(-33.45694, -70.64827) );
		TerminalPortuaria laPaz = new TerminalPortuaria( "La Paz", new Point2D.Double(-16.5, -68.15) );

		// Tramos circuito 1째
		Tramo bsAsSaoPablo = new Tramo(bsAs, saoPablo, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10);
		Tramo saoPabloMontevideo  = new Tramo(saoPablo, montevideo, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		Tramo montevideoAsuncion  = new Tramo(montevideo, asuncion, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		Tramo asuncionLima  = new Tramo(asuncion, lima, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		Tramo limaSantiagoDeChile  = new Tramo(lima, santiagoDeChile, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		Tramo santiagoDeChileLaPaz  = new Tramo(santiagoDeChile, laPaz, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		
		// Tramos circuito 2째
		Tramo saoPabloLima = new Tramo(saoPablo, lima, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10);
		// Tramo limaSantiagoDeChile  = new Tramo(lima, santiagoDeChile, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		Tramo santiagoDeChileMontevideo  = new Tramo(santiagoDeChile, montevideo, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		Tramo montevideoBsAs  = new Tramo(montevideo, bsAs, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		Tramo bsAsLaPaz  = new Tramo(bsAs, laPaz, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		Tramo laPazAsuncion  = new Tramo(laPaz, asuncion, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		
		// Tramos circuito 3째
		Tramo limaBsAs = new Tramo(lima, bsAs, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10);
		Tramo bsAsSantiagoDeChile  = new Tramo(bsAs, santiagoDeChile, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		Tramo santiagoDeChileAsuncion  = new Tramo(santiagoDeChile, asuncion, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		Tramo asuncionSaoPablo  = new Tramo(asuncion, saoPablo, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		// Tramo saoPabloMontevideo  = new Tramo(saoPablo, montevideo, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		Tramo montevideoLaPaz  = new Tramo(montevideo, laPaz, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0, 10 );
		
		
		// Lista de tramos del circuito 1°
		List<Tramo>listaTramosNro1 = new ArrayList<Tramo> // Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						bsAsSaoPablo, saoPabloMontevideo, montevideoAsuncion, asuncionLima, limaSantiagoDeChile, santiagoDeChileLaPaz
				)
		);
		
		// Lista de tramos del circuito 2°
		List<Tramo>listaTramosNro2 = new ArrayList<Tramo> // Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						saoPabloLima, limaSantiagoDeChile, santiagoDeChileMontevideo, montevideoBsAs, bsAsLaPaz, laPazAsuncion
				)
		);
		
		// Lista de tramos del circuito 3°
		List<Tramo>listaTramosNro3 = new ArrayList<Tramo> // Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						limaBsAs, bsAsSantiagoDeChile, santiagoDeChileAsuncion, asuncionSaoPablo, saoPabloMontevideo, montevideoLaPaz
				)
		);
		
	
		// Circuitos
		Circuito circuito1 = new Circuito( listaTramosNro1, LocalDateTime.of(2023, 11, 18, 11, 00) );
		Circuito circuito2 = new Circuito( listaTramosNro2, LocalDateTime.of(2023, 11, 18, 11, 00) );
		Circuito circuito3 = new Circuito( listaTramosNro3, LocalDateTime.of(2023, 11, 18, 11, 00) );
		
		
		Naviera miNaviera = new Naviera();
		miNaviera.agregarCircuito(circuito1);
		miNaviera.agregarCircuito(circuito2);
		miNaviera.agregarCircuito(circuito3);
		
		
		bsAs.registrarNuevaNaviera(miNaviera);
    	
		
		MenorCantidadTerminal mejorRuta2 = new MenorCantidadTerminal();
		
		bsAs.setMejorCircuito(mejorRuta2);
		
		

			assertEquals(circuito3, bsAs.getMejorCircuito( asuncion ));

		

    }
}
