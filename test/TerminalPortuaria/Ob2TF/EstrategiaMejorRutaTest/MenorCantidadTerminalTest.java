package TerminalPortuaria.Ob2TF.EstrategiaMejorRutaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

class MenorCantidadTerminalTest {
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
	Circuito circuito4;
	
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
	List<Tramo> tramosCir4;
	

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
		circuito4 = mock(Circuito.class);
		
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
		
		todoCircuito = Arrays.asList(circuito1, circuito2, circuito3,circuito4);
		
		// Lista de Tramos
		tramosCir1 = Arrays.asList(tramo1, tramo2,tramo3);
		tramosCir2 = Arrays.asList(tramo4, tramo5,tramo6);
		tramosCir3 = Arrays.asList(tramo7,tramo8,tramo9);
		tramosCir4 = Arrays.asList(tramo1, tramo5);
		
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
		
		when(circuito1.construirCircuitoDesdeHasta(bsAs, saoPablo)).thenReturn(circuito4);
		when(circuito3.construirCircuitoDesdeHasta(bsAs, saoPablo)).thenReturn(circuito2);
		
		when(circuito1.cantidadDeEscalas()).thenReturn(1);// si el puerto destino es SaoPablo
		when(circuito3.cantidadDeEscalas()).thenReturn(2);// si el puerto destino es SaoPablo
	
	}

	@Test
	void tieneMenosEscalasTest() {
		assertTrue(mejorRuta2.tieneMenosEscalas(circuito1, circuito3));
	}
    @Test
    void mejorCircuitoParaMenorCantidadDeEscalasTest() {
        assertEquals(circuito3, mejorRuta2.mejorCircuito(bsAs, saoPablo));
    }
	
}
