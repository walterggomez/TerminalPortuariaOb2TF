package TerminalPortuaria.Ob2TF.BusquedaMaritimaTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.*;

import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.MenorCantidadTerminal;
import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.MenorPrecio;
import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.MenorTiempo;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;
import TerminalPortuaria.Ob2TF.BusquedaMaritima.*;


import org.junit.jupiter.api.Test;

class BusquedaMaritimaTest {

	OperadorAND busqueda;
	
	TerminalPortuaria bsAs;
	TerminalPortuaria saoPablo;
	TerminalPortuaria busan;
	TerminalPortuaria hongKong;

	

	
	LocalDate fechaLlegada;
	
	Viaje viajePorSanPablo;
	Viaje viajePorBsAs;
	Viaje ViajeConLlegadaBien;
	Viaje ViajeConLlegadaMal;
	Viaje ViajeConSalidaBien;
	Viaje ViajeConSalidaMal;
	Viaje viaje7;
	
	
	List<Viaje> todosLosViajes;
	
	
	@BeforeEach
	void setUp() throws Exception {
		// Estrategia 
		busqueda = new OperadorAND("NombrePrueba");
		
		// TerminalPortuaria
		bsAs = mock(TerminalPortuaria.class);
		saoPablo = mock(TerminalPortuaria.class);
		busan = mock(TerminalPortuaria.class);
		hongKong = mock(TerminalPortuaria.class);


		
		//Viajes
		viajePorSanPablo = mock(Viaje.class);
		viajePorBsAs = mock(Viaje.class);
		ViajeConLlegadaBien = mock(Viaje.class);
		ViajeConLlegadaMal = mock(Viaje.class);
		ViajeConSalidaBien = mock(Viaje.class);
		ViajeConSalidaMal = mock(Viaje.class);
		viaje7 = mock(Viaje.class);
		

		
		// Lista de viajes
		List<Viaje> viajesSoloASanPablo = Arrays.asList(viajePorSanPablo);
		
		todosLosViajes = (List<Viaje>) mock(Viaje.class);
		
	
	
	}
	
	

}
