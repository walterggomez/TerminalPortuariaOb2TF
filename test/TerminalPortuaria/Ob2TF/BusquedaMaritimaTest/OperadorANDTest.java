package TerminalPortuaria.Ob2TF.BusquedaMaritimaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.BusquedaMaritima.FiltroPuertoDestino;
import TerminalPortuaria.Ob2TF.BusquedaMaritima.OperadorAND;
import TerminalPortuaria.Ob2TF.BusquedaMaritima.OperadorOR;
import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class OperadorANDTest {

	//OPERADORES OR
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
	
	List<Viaje> viajes1;
	List<Viaje> viajes2;
	List<Viaje> viajes3;
	List<Viaje> listaSinViajes;
	
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
		
		compo1 = new OperadorAND("Operador1");
		compo2 = new OperadorAND("Operador2");
		compo3 = new OperadorAND("Operador3");
		viajeBsAsSanPabloMonteVideo = mock(Viaje.class);
		viajeAsuncionLimaSantiago = mock(Viaje.class);
		viajeLimaSantiagoLaPaz = mock(Viaje.class);
		viajeBsAsMontevideoLima = mock(Viaje.class);
		viajeSanPabloMontevideoLima = mock(Viaje.class);
		
		listaSinViajes = new ArrayList<>();
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
		
		when(viajeAMontevideo.filtrar(viajes1)).thenReturn(viajeAMonte);
		
//		FiltroPuertoDestino viajeAMontevideo;
//		FiltroPuertoDestino viajeASantiago;
//		FiltroPuertoDestino viajeALaPaz;
//		FiltroPuertoDestino viajeABsAs;
//		FiltroPuertoDestino viajeALima;
		
	}
	
	//AGREGO ELEMENTOS COMPUESTOS DE FILTRO PUERTO DESTINO A MONTEVIDEO Y LIMA
	@Test
	void testResultadoOR() {
		compo1.Agregar(viajeAMontevideo);
		compo1.Agregar(viajeALima);
		assertEquals(compo1.filtrar(viajes1), listaSinViajes);
	}
	
	
	//TEST AGREGAR HIJOS
	@Test
	void testAgregar() {
		compo1.Agregar(viajeAMontevideo);
		compo1.Agregar(viajeALima);
		assertEquals(compo1.getHijos().size(), 2);
	}
	
	
	//TEST ELIMINAR HIJOS
	@Test
	void testEliminar() {
		compo1.Agregar(viajeAMontevideo);
		compo1.Agregar(viajeALima);
		assertEquals(compo1.getHijos().size(), 2);
		compo1.Remover(viajeALima);
		assertEquals(compo1.getHijos().size(), 1);
	}

}
