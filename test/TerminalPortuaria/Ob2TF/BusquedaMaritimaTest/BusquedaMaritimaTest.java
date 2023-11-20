package TerminalPortuaria.Ob2TF.BusquedaMaritimaTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.*;

import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;
import TerminalPortuaria.Ob2TF.BusquedaMaritima.*;


import org.junit.jupiter.api.Test;

class BusquedaMaritimaTest {

	OperadorAND compo1;
	OperadorAND compo2;
	OperadorAND compo3;
	
	
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
	
	// Viajes
	Viaje viajeBsAsSanPabloMonteVideo;
	Viaje viajeAsuncionLimaSantiago;
	Viaje viajeLimaSantiagoLaPaz;
	Viaje viajeBsAsMontevideoLima;
	Viaje viajeSanPabloMontevideoLima;
	
	List<Viaje> todosLosViajes;
	
	//FiltrosPuertoDestino
	FiltroPuertoDestino viajeAMontevideo;
	FiltroPuertoDestino viajeASantiago;
	FiltroPuertoDestino viajeALaPaz;
	FiltroPuertoDestino viajeABsAs;
	FiltroPuertoDestino viajeALima;

	
	
	@BeforeEach
	void setUp() throws Exception {
		viajeBsAsSanPabloMonteVideo = mock(Viaje.class);
		viajeAsuncionLimaSantiago = mock(Viaje.class);
		viajeLimaSantiagoLaPaz = mock(Viaje.class);
		viajeBsAsMontevideoLima = mock(Viaje.class);
		viajeSanPabloMontevideoLima = mock(Viaje.class);
		
		compo1 = new OperadorAND("BusquedaDestinoMonteVideo");
		compo2 = new OperadorAND("BusquedaDestinoLima");
		compo3 = new OperadorAND("BusquedaDestinoLaPaz");
		
		when(viajeBsAsSanPabloMonteVideo.getpuertoDestino()).thenReturn(montevideo);
		when(viajeAsuncionLimaSantiago.getpuertoDestino()).thenReturn(santiagoDeChile);
		when(viajeLimaSantiagoLaPaz.getpuertoDestino()).thenReturn(laPaz);
		when(viajeBsAsMontevideoLima.getpuertoDestino()).thenReturn(lima);
		when(viajeSanPabloMontevideoLima.getpuertoDestino()).thenReturn(lima);
		
		compo1.Agregar(compo1);
		
		
	
	
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	

}
