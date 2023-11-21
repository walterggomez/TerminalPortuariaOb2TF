package TerminalPortuaria.Ob2TF.BusquedaMaritimaTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
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

	//OPERADORES AND
	OperadorOR compo1;
	OperadorOR compo2;
	OperadorOR compo3;
	
	//FiltrosPuertoDestino
	FiltroPuertoDestino destinoAMontevideo;
	FiltroPuertoDestino destinoALima;
	FiltroPuertoDestino destinoABsAs;
	
	
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
	
	List<Viaje> viajes1;
	List<Viaje> viajes2;
	List<Viaje> viajes3;
	
	List<Viaje> viajesABsAs;
	List<Viaje> viajeAMonteYLima;
	List<Viaje> viajeAMonte;
	List<Viaje> viajeALimaPeru;
	
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
		
		viajesABsAs = new ArrayList<>();
		viajeAMonteYLima = new ArrayList<>();
		viajeAMonte = new ArrayList<>();
		viajeALimaPeru = new ArrayList<>();
		viajes1 = new ArrayList<>();
		viajes2 = new ArrayList<>();
		viajes3 = new ArrayList<>();
		viajesABsAs.add(viajeLimaSantiagoLaPaz);
		viajeAMonteYLima.add(viajeBsAsSanPabloMonteVideo);
		viajeAMonteYLima.add(viajeBsAsMontevideoLima);
		viajeAMonte.add(viajeBsAsSanPabloMonteVideo);
		viajeALimaPeru.add(viajeBsAsMontevideoLima);
		viajes1.add(viajeBsAsSanPabloMonteVideo);
		viajes1.add(viajeSanPabloMontevideoLima);
		viajes1.add(viajeAsuncionLimaSantiago);
		viajes2.add(viajeLimaSantiagoLaPaz);
		viajes3.add(viajeBsAsMontevideoLima);
		viajes3.add(viajeSanPabloMontevideoLima);

		
		compo1 = new OperadorOR("BusquedaDestinoMonteVideoYLima");
		compo2 = new OperadorOR("BusquedaDestinoLimaYSantiago");
		compo3 = new OperadorOR("BusquedaDestinoLaPazYBsAs");
		
		
		viajeAMontevideo = mock(FiltroPuertoDestino.class);
		viajeASantiago = mock(FiltroPuertoDestino.class);
		viajeALaPaz = mock(FiltroPuertoDestino.class);
		viajeABsAs = mock(FiltroPuertoDestino.class);
		viajeALima = mock(FiltroPuertoDestino.class);
		
		when(viajeAMontevideo.filtrar(viajes1)).thenReturn(viajeAMonte);
		when(viajeASantiago.filtrar(viajes1)).thenReturn(viajesABsAs);
		when(viajeALaPaz.filtrar(viajes1)).thenReturn(viajesABsAs);
		when(viajeABsAs.filtrar(viajes1)).thenReturn(viajesABsAs);
		when(viajeALima.filtrar(viajes1)).thenReturn(viajeALimaPeru);
		
		
		
		when(viajeBsAsSanPabloMonteVideo.getpuertoDestino()).thenReturn(montevideo);
		when(viajeAsuncionLimaSantiago.getpuertoDestino()).thenReturn(santiagoDeChile);
		when(viajeLimaSantiagoLaPaz.getpuertoDestino()).thenReturn(laPaz);
		when(viajeBsAsMontevideoLima.getpuertoDestino()).thenReturn(lima);
		when(viajeSanPabloMontevideoLima.getpuertoDestino()).thenReturn(lima);
		
//		when(viajeAMontevideo.filtrar(viajes1)).thenReturn(viajeAMonte);
		
//		FiltroPuertoDestino viajeAMontevideo;
//		FiltroPuertoDestino viajeASantiago;
//		FiltroPuertoDestino viajeALaPaz;
//		FiltroPuertoDestino viajeABsAs;
//		FiltroPuertoDestino viajeALima;
		
	}
	
	@Test
	void test() {
		compo1.Agregar(viajeAMontevideo);
		compo1.Agregar(viajeALima);
		assertEquals(compo1.filtrar(viajes1), viajeAMonteYLima);
	}

	

}
