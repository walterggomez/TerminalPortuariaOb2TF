package TerminalPortuaria.Ob2TF.TerminalPTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class TerminalPortuariaTest{
	TerminalPortuaria bsAs;
	TerminalPortuaria saoPablo;
	
	Point2D latitudLongitudBsAs;
	Point2D latitudLongitudSaoPablo;
	
	Naviera naviera1; // [circuito1, circuito2, circuito3]
	Naviera naviera2;
	
	Circuito circuito1; // [tramo1,tramo2,tramo3]-> bsAs - saoPablo - busan - hongKong
	Circuito circuito2; // [tramo4,tramo5,tramo6]-> bsAs - cartagena - shanghai - singapur
	Circuito circuito3; // [tramo7,tramo8,tramo9]-> bsAs - longBeach - saoPablo - cartagena
	Circuito circuito4;
	Circuito circuito5;
	Circuito circuito6;
	
	List<Circuito> circuitosN1;
	List<Circuito> circuitosN2;


	@BeforeEach
	void setUp() throws Exception{
		
		latitudLongitudBsAs = new Point2D.Double(-34.61315, -58.37723);
		latitudLongitudSaoPablo = new Point2D.Double(-23.5475, -46.63611);
		
		
		bsAs = new TerminalPortuaria(latitudLongitudBsAs);
		saoPablo = new TerminalPortuaria(latitudLongitudSaoPablo);
		
		naviera1 = mock(Naviera.class);
		naviera2 = mock(Naviera.class);
		
		//Circuito
		circuito1 = mock(Circuito.class);
		circuito2 = mock(Circuito.class);
		circuito3 = mock(Circuito.class);
		
		circuito4 = mock(Circuito.class);
		circuito5 = mock(Circuito.class);
		circuito6 = mock(Circuito.class);
		
		circuitosN1 = Arrays.asList(circuito1, circuito2, circuito3);
		circuitosN2 = Arrays.asList(circuito4, circuito5, circuito6);
		
		when(naviera1.getMisCircuitos()).thenReturn(circuitosN1);
		when(naviera2.getMisCircuitos()).thenReturn(circuitosN2);
		
		
		when(circuito1.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(true);
		when(circuito2.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(false);
		when(circuito3.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(false);
		
		when(circuito4.validarSiTerminalExisteEnCircuito(saoPablo)).thenReturn(false);
		when(circuito5.validarSiTerminalExisteEnCircuito(saoPablo)).thenReturn(false);
		when(circuito6.validarSiTerminalExisteEnCircuito(saoPablo)).thenReturn(false);
		
	}
	

	@Test
	void registrarNuevaNavieraTestOk(){ // se espera resultado ok
		bsAs.registrarNuevaNaviera(naviera1);
		assertEquals(1,bsAs.getMisNavieras().size());
	}
	@Test
	void registrarNuevaNavieraTest(){ 
		saoPablo.registrarNuevaNaviera(naviera2);
		assertEquals(0,saoPablo.getMisNavieras().size());
	}
	@Test
	void estoyEnUnCircuitoDeLaNavieraTest(){
		assertTrue(bsAs.estoyEnUnCircuitoDeLaNaviera(naviera1));
		assertFalse(saoPablo.estoyEnUnCircuitoDeLaNaviera(naviera1));
	}

}

