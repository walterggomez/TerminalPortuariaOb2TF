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
	
	Naviera naviera;
	
	Circuito circuito1;
	Circuito circuito2;
	Circuito circuito3;
	Circuito circuito4;
	Circuito circuito5;
	
	List<Circuito> circuitos;

	@BeforeEach
	void setUp() throws Exception {
		
		terminalBsAs= mock(TerminalPortuaria.class);
		naviera = mock(Naviera.class);
		
		circuito1 = mock(Circuito.class);
		circuito2 = mock(Circuito.class);
		circuito3 = mock(Circuito.class);
		circuito4 = mock(Circuito.class);
		circuito5 = mock(Circuito.class);
		
		circuitos =  Arrays.asList(circuito1,circuito2,circuito3,circuito4,circuito5);
	
		
	}

	@Test
	void test() {
		when(naviera.methodCall).thenReturn(circuitos);

		fail("Not yet implemented");
	}

}
