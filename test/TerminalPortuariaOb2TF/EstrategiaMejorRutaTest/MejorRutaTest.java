package TerminalPortuariaOb2TF.EstrategiaMejorRutaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Circuito.Tramo;
import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.MejorRuta;
import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.MenorPrecio;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class MejorRutaTest {
	
	MejorRuta mejorRuta1;

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
	Circuito circuito2; // [tramo4,tramo5,tramo6]-> bsAs - cartagena - shanghai - singapur
	Circuito circuito3; // [tramo7,tramo8,tramo9]-> bsAs - longBeach - saoPablo - cartagena
	
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
		
		when(circuito1.contieneA(bsAs)).thenReturn(true);
		when(circuito2.contieneA(bsAs)).thenReturn(true);
		when(circuito3.contieneA(bsAs)).thenReturn(true);
		
		when(circuito1.contieneA(saoPablo)).thenReturn(true);
		when(circuito1.contieneA(busan)).thenReturn(true);
		when(circuito1.contieneA(hongKong)).thenReturn(true);
		
		when(circuito2.contieneA(cartagena)).thenReturn(true);
		when(circuito2.contieneA(shanghai)).thenReturn(true);
		when(circuito2.contieneA(singapur)).thenReturn(true);
		
		when(circuito3.contieneA(longBeach)).thenReturn(true);
		when(circuito3.contieneA(saoPablo)).thenReturn(true);
		when(circuito3.contieneA(cartagena)).thenReturn(true);
		
		
		when(tramo1.getPuertoOrigen()).thenReturn(bsAs);
		when(tramo1.getPuertoDestino()).thenReturn(saoPablo);
		when(tramo1.getCostoDetramo()).thenReturn(50.0);
		//when(tramo1.getDuracionTramo()).thenReturn(5.0);
		
		when(tramo2.getPuertoOrigen()).thenReturn(saoPablo);
		when(tramo2.getPuertoDestino()).thenReturn(busan);
		
		when(tramo3.getPuertoOrigen()).thenReturn(busan);
		when(tramo3.getPuertoDestino()).thenReturn(hongKong);
	

		
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
	void listaDeCircuitos() {
		
		List<Circuito> circuitosBuscados= Arrays.asList(circuito1,circuito3);
		
		/*when(circuito1.costoTotalDelCircuito()).thenReturn(100.0);
		when(circuito2.costoTotalDelCircuito()).thenReturn(150.0);
		when(circuito3.costoTotalDelCircuito()).thenReturn(50.0);*/
		
		
		assertEquals(circuitosBuscados, mejorRuta1.listaDeCircuitos(bsAs, saoPablo));
		
	}

}
