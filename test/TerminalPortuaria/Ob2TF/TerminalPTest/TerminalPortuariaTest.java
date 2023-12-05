package TerminalPortuaria.Ob2TF.TerminalPTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Circuito.Tramo;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class TerminalPortuariaTest
{
	
	// Circuitos
	Circuito circuito1;
	Circuito circuito2;
	Circuito circuito3;
	
	
	// Puertos
	TerminalPortuaria bsAs;
	TerminalPortuaria saoPablo;
	TerminalPortuaria montevideo;
	TerminalPortuaria asuncion;
	TerminalPortuaria lima;
	TerminalPortuaria santiagoDeChile;
	TerminalPortuaria laPaz;

	
	// Tramos que conforman circuito 1°.
	Tramo bsAsSaoPablo;
	Tramo saoPabloMontevideo;
	Tramo montevideoAsuncion;
	Tramo asuncionLima; 
	Tramo limaSantiagoDeChile;
	Tramo santiagoDeChileLaPaz;
	
	// Tramos que conforman cirucito 2°
	Tramo saoPabloLima;
	// Tramo limaSantiagoDeChile; 
	Tramo santiagoDeChileMontevideo; 
	Tramo montevideoBsAs;
	Tramo bsAsLaPaz;
	Tramo laPazAsuncion;
	
	// Tramos que conforman circuito 3°
	Tramo limaBsAs;
	Tramo bsAsSantiagoDeChile;
	Tramo santiagoDeChileAsuncion;
	Tramo asuncionSaoPablo;
	// Tramo saoPabloMontevideo;
	Tramo montevideoLaPaz;
	
	// Listas de tramos
	List<Tramo> listaTramosNro1;
	List<Tramo> listaTramosNro2;
	List<Tramo> listaTramosNro3;
	
	
	// Navieras
	Naviera naviera1;
	Naviera naviera2;
	Naviera naviera3;
	
	
	
	
	@BeforeEach
	void setUp() throws Exception 
	{
		// Mocks de las terminales
		bsAs = mock(TerminalPortuaria.class);
		saoPablo = mock(TerminalPortuaria.class);
		montevideo = mock(TerminalPortuaria.class);
		asuncion = mock(TerminalPortuaria.class);
		lima = mock(TerminalPortuaria.class);
		santiagoDeChile = mock(TerminalPortuaria.class);
		laPaz = mock(TerminalPortuaria.class);
		
		// getUbicacion() de las terminales
		when(bsAs.getUbicacion()).thenReturn( new Point2D.Double(-34.61315, -58.37723) );
		when(saoPablo.getUbicacion()).thenReturn( new Point2D.Double(-23.5475, -46.63611) );
		when(montevideo.getUbicacion()).thenReturn( new Point2D.Double(-34.90328, -56.18816) );
		when(asuncion.getUbicacion()).thenReturn( new Point2D.Double(-25.28646, -57.647) );
		when(lima.getUbicacion()).thenReturn( new Point2D.Double(-12.04318, -77.02824) );
		when(santiagoDeChile.getUbicacion()).thenReturn( new Point2D.Double(-33.45694, -70.64827) );
		when(laPaz.getUbicacion()).thenReturn( new Point2D.Double(-16.5, -68.15) );
		
		
		// Spy de los tramos del circuito 1°
		bsAsSaoPablo = spy( new Tramo() );
		saoPabloMontevideo = spy( new Tramo() );
		montevideoAsuncion = spy( new Tramo() );
		asuncionLima = spy( new Tramo() );
		limaSantiagoDeChile = spy( new Tramo() );
		santiagoDeChileLaPaz = spy( new Tramo() );
		
		// Spy de los tramos del circuito 2°
		saoPabloLima = spy( new Tramo() );
		// limaSantiagoDeChile = spy( new Tramo() );
		santiagoDeChileMontevideo = spy( new Tramo() );
		montevideoBsAs = spy( new Tramo() );
		bsAsLaPaz = spy( new Tramo() );
		laPazAsuncion = spy( new Tramo() );
		
		// Spy de los tramos del circuito 3°
		limaBsAs = spy( new Tramo() );
		bsAsSantiagoDeChile = spy( new Tramo() );
		santiagoDeChileAsuncion = spy( new Tramo() );
		asuncionSaoPablo = spy( new Tramo() );
		// saoPabloMontevideo = spy( new Tramo() );
		montevideoLaPaz = spy( new Tramo() );
		
		


		
		// Tramo a agregar, sin continuidad con el último puerto del circuito
		asuncionSaoPablo = spy( Tramo.class );
		when( asuncionSaoPablo.getPuertoOrigen() ).thenReturn(asuncion);
		when( asuncionSaoPablo.getPuertoDestino() ).thenReturn(saoPablo);
		
		
		// Tramo a agregar el cual coincide con el último puerto del circuito
		laPazAsuncion = spy( Tramo.class );
		when( laPazAsuncion.getPuertoOrigen() ).thenReturn(laPaz);
		when( laPazAsuncion.getPuertoDestino() ).thenReturn(asuncion);
		
		
		// Puertos de los tramos
		when( bsAsSaoPablo.getPuertoOrigen() ).thenReturn(bsAs);
		when( bsAsSaoPablo.getPuertoDestino() ).thenReturn(saoPablo);
		when( saoPabloMontevideo.getPuertoOrigen() ).thenReturn(saoPablo);
		when( saoPabloMontevideo.getPuertoDestino() ).thenReturn(montevideo);
		when( montevideoAsuncion.getPuertoOrigen() ).thenReturn(montevideo);
		when( montevideoAsuncion.getPuertoDestino() ).thenReturn(asuncion);
		when( asuncionLima.getPuertoOrigen() ).thenReturn(asuncion);
		when( asuncionLima.getPuertoDestino() ).thenReturn(lima);
		when( limaSantiagoDeChile.getPuertoOrigen() ).thenReturn(lima);
		when( limaSantiagoDeChile.getPuertoDestino() ).thenReturn(santiagoDeChile);
		when( santiagoDeChileLaPaz.getPuertoOrigen() ).thenReturn(santiagoDeChile);
		when( santiagoDeChileLaPaz.getPuertoDestino() ).thenReturn(laPaz);

		
		// Duración de los tramos
		when( bsAsSaoPablo.getDuracionTramo() ).thenReturn(10.0);
		when( saoPabloMontevideo.getDuracionTramo() ).thenReturn(10.0);
		when( montevideoAsuncion.getDuracionTramo() ).thenReturn(10.0);
		when( asuncionLima.getDuracionTramo() ).thenReturn(10.0);
		when( limaSantiagoDeChile.getDuracionTramo() ).thenReturn(10.0);
		when( santiagoDeChileLaPaz.getDuracionTramo() ).thenReturn(10.0);
		
		// TerminalPortuaria montevideo = new TerminalPortuaria( new Point2D.Double(-34.90328, -56.18816) );
		// TerminalPortuaria santiagoDeChile = new TerminalPortuaria( new Point2D.Double(-33.45694, -70.64827) );
		
		
		// Lista de tramos 1°
		listaTramosNro1 = new ArrayList<Tramo> // Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						bsAsSaoPablo, saoPabloMontevideo, montevideoAsuncion, asuncionLima, limaSantiagoDeChile, santiagoDeChileLaPaz
				)
		);
		

		// Lista de tramos 2°
		listaTramosNro2 = new ArrayList<Tramo> // Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						saoPabloLima, limaSantiagoDeChile, santiagoDeChileMontevideo, montevideoBsAs, bsAsLaPaz, laPazAsuncion
				)
		);
		
		
		// Lista de tramos 3°
		listaTramosNro3 = new ArrayList<Tramo> // Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						limaBsAs, bsAsSantiagoDeChile, santiagoDeChileAsuncion, asuncionSaoPablo, saoPabloMontevideo, montevideoLaPaz
				)
		);

		
		// Lista de tramos vacía
		listaTramosNro2 = new ArrayList<Tramo>();
	
		// Spy de los circuitos
		circuito1 = spy( new Circuito(listaTramosNro1, LocalDateTime.now()) );
		
		
		
	}
	
	

	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	TerminalPortuaria bsAs;
//	TerminalPortuaria saoPablo;
//	
//	Point2D latitudLongitudBsAs;
//	Point2D latitudLongitudSaoPablo;
//	
//	Naviera naviera1; // [circuito1, circuito2, circuito3]
//	Naviera naviera2;
//	
//	Circuito circuito1; // [tramo1,tramo2,tramo3]-> bsAs - saoPablo - busan - hongKong
//	Circuito circuito2; // [tramo4,tramo5,tramo6]-> bsAs - cartagena - shanghai - singapur
//	Circuito circuito3; // [tramo7,tramo8,tramo9]-> bsAs - longBeach - saoPablo - cartagena
//	Circuito circuito4;
//	Circuito circuito5;
//	Circuito circuito6;
//	
//	List<Circuito> circuitosN1;
//	List<Circuito> circuitosN2;
//
//
//	@BeforeEach
//	void setUp() throws Exception{
//		
//		latitudLongitudBsAs = new Point2D.Double(-34.61315, -58.37723);
//		latitudLongitudSaoPablo = new Point2D.Double(-23.5475, -46.63611);
//		
//		
//		bsAs = new TerminalPortuaria("Buenos Aires", latitudLongitudBsAs);
//		saoPablo = new TerminalPortuaria("Sao Pablo", latitudLongitudSaoPablo);
//		
//		naviera1 = mock(Naviera.class);
//		naviera2 = mock(Naviera.class);
//		
//		
//		//Circuito
//		circuito1 = mock(Circuito.class);
//		circuito2 = mock(Circuito.class);
//		circuito3 = mock(Circuito.class);
//		
//		circuito4 = mock(Circuito.class);
//		circuito5 = mock(Circuito.class);
//		circuito6 = mock(Circuito.class);
//		
//		circuitosN1 = Arrays.asList(circuito1, circuito2, circuito3);
//		circuitosN2 = Arrays.asList(circuito4, circuito5, circuito6);
//		
//		when(naviera1.getMisCircuitos()).thenReturn(circuitosN1);
//		when(naviera2.getMisCircuitos()).thenReturn(circuitosN2);
//		
//		
//		when(circuito1.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(true);
//		when(circuito2.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(false);
//		when(circuito3.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(false);
//		
//		when(circuito4.validarSiTerminalExisteEnCircuito(saoPablo)).thenReturn(false);
//		when(circuito5.validarSiTerminalExisteEnCircuito(saoPablo)).thenReturn(false);
//		when(circuito6.validarSiTerminalExisteEnCircuito(saoPablo)).thenReturn(false);
//		
//	}
//	
//
//	@Test
//	void registrarNuevaNavieraTestOk(){ // se espera resultado valido
//		bsAs.registrarNuevaNaviera(naviera1);
//		assertEquals(1,bsAs.getMisNavieras().size());
//	}
//	@Test
//	void registrarNuevaNavieraTest(){ // se espera resultado NO valido
//		saoPablo.registrarNuevaNaviera(naviera2);
//		assertEquals(0,saoPablo.getMisNavieras().size());
//	}
//	@Test
//	void estoyEnUnCircuitoDeLaNavieraTest(){
//		assertTrue(bsAs.estoyEnUnCircuitoDeLaNaviera(naviera1));
//		assertFalse(saoPablo.estoyEnUnCircuitoDeLaNaviera(naviera1));
//	}
//	@Test
//	void getUbicacionTest(){
//		assertEquals(latitudLongitudBsAs,bsAs.getUbicacion());
//		assertEquals(latitudLongitudSaoPablo,saoPablo.getUbicacion());
//	}
//
//}

