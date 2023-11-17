package TerminalPortuaria.Ob2TF.TerminalPTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class TerminalPortuariaTest{
	TerminalPortuaria bsAs;
	
	Naviera naviera1; // [circuito1, circuito2, circuito3]
	
	Circuito circuito1; // [tramo1,tramo2,tramo3]-> bsAs - saoPablo - busan - hongKong
	Circuito circuito2; // [tramo4,tramo5,tramo6]-> bsAs - cartagena - shanghai - singapur
	Circuito circuito3; // [tramo7,tramo8,tramo9]-> bsAs - longBeach - saoPablo - cartagena
	
	List<Circuito> circuitosN1;


	@BeforeEach
	void setUp() throws Exception{
		
		bsAs = new TerminalPortuaria();
		
		naviera1 = mock(Naviera.class);
		
		//Circuito
		circuito1 = mock(Circuito.class);
		circuito2 = mock(Circuito.class);
		circuito3 = mock(Circuito.class);
		
		circuitosN1 = Arrays.asList(circuito1, circuito2, circuito3);
		
		when(naviera1.getMisCircuitos()).thenReturn(circuitosN1);
		
		
		when(circuito1.contieneA(bsAs)).thenReturn(true);
		when(circuito2.contieneA(bsAs)).thenReturn(false);
		when(circuito3.contieneA(bsAs)).thenReturn(false);
		
	}
	

	/*@Test
	void registrarNuevaNavieraTest(){
		
		
		
		
		fail("Not yet implemented");
	}*/
	@Test
	void estoyEnUnCircuitoDeLaNavieraTest(){
		assertTrue(bsAs.estoyEnUnCircuitoDeLaNaviera(naviera1));
	}

}

