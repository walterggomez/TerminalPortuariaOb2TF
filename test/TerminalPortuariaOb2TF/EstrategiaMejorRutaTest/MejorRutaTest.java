package TerminalPortuariaOb2TF.EstrategiaMejorRutaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class MejorRutaTest {
	
	TerminalPortuaria terminalBsAs;
	
	Naviera naviera1;
	Naviera naviera2;
	
	Circuito circuito1;
	Circuito circuito2;
	Circuito circuito3;
	Circuito circuito4;
	Circuito circuito5;
	Circuito circuito6;
	Circuito circuito7;
	Circuito circuito8;
	Circuito circuito9;
	Circuito circuito10;
	
	List<Circuito> circuitosN1;
	List<Circuito> circuitosN2;

	@BeforeEach
	void setUp() throws Exception {
		
		terminalBsAs= mock(TerminalPortuaria.class);
		naviera1 = mock(Naviera.class);
		naviera2 = mock(Naviera.class);
		
		circuito1 = mock(Circuito.class);
		circuito2 = mock(Circuito.class);
		circuito3 = mock(Circuito.class);
		circuito4 = mock(Circuito.class);
		circuito5 = mock(Circuito.class);
		
		circuitosN1 =  Arrays.asList(circuito1,circuito2,circuito3,circuito4,circuito5);
		circuitosN2 =  Arrays.asList(circuito6,circuito7,circuito8,circuito9,circuito10);
	
		
	}

	@Test
	void test() {
		

		fail("Not yet implemented");
	}

}
