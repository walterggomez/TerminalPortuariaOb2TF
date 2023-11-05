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
	TerminalPortuaria simgapur;
	TerminalPortuaria longBeach;
	

	Naviera naviera1;
	Naviera naviera2;

	List<Naviera> navieras;

	Tramo tramo1;
	Tramo tramo2;
	Tramo tramo3;
	
	
	
	
	Circuito circuito1;
	Circuito circuito2;
	Circuito circuito3;
	
	List<Circuito> circuitosN1;
	List<Circuito> circuitosN2;
	List<Circuito> circuitosN3;

	List<Circuito> todoCircuito;
	
	

	@BeforeEach
	void setUp() throws Exception {

		bsAs = mock(TerminalPortuaria.class);
		
		
		
		
		
		
		naviera1 = mock(Naviera.class);
		naviera2 = mock(Naviera.class);
		

		navieras = Arrays.asList(naviera1, naviera2);

		circuito1 = mock(Circuito.class);
		circuito2 = mock(Circuito.class);
		circuito3 = mock(Circuito.class);
		

		circuitosN1 = Arrays.asList(circuito1, circuito2);
		circuitosN2 = Arrays.asList(circuito3); 
		
		when(bsAs.getMisNavieras()).thenReturn(navieras);
		when(naviera1.getMisCircuitos()).thenReturn(circuitosN1);
		when(naviera2.getMisCircuitos()).thenReturn(circuitosN2);

		mejorRuta1 = new MenorPrecio();

		todoCircuito = Arrays.asList(circuito1, circuito2, circuito3);
	}

	@Test
	void navierasDelPuertoTest() {
		assertEquals(navieras, mejorRuta1.navierasDelPuerto(bsAs));

	}

	@Test
	void todosLosCircuitosMaritimosTest() {
		assertEquals(todoCircuito, mejorRuta1.todosLosCircuitosMaritimos(navieras));

	}
	/*@Test
	void menorPrecioTest() {
		when(circuito1.costoTotalDelCircuito()).thenReturn(100.0);
		when(circuito2.costoTotalDelCircuito()).thenReturn(150.0);
		when(circuito3.costoTotalDelCircuito()).thenReturn(50.0);
		
		
		assertEquals(circuito3, mejorRuta1.mejorCircuito(bsAs, saoPablo));
		
	}*/

}
