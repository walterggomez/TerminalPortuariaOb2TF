package TerminalPortuaria.Ob2TF.BusquedaMaritimaTest;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.BusquedaMaritima.FiltroFechaLlegada;
import TerminalPortuaria.Ob2TF.BusquedaMaritima.FiltroPuertoDestino;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class FiltroFechaLlegadaTest {

	//FILTROS
	FiltroFechaLlegada filtroFecha1;
	FiltroFechaLlegada filtroFecha2;
	
	TerminalPortuaria bsAs;
	TerminalPortuaria lima;
	TerminalPortuaria montevideo;
	TerminalPortuaria santiago;
	TerminalPortuaria laPaz;
	

	LocalDateTime fecha1;
	LocalDateTime fecha2;
	LocalDateTime fecha3;
	LocalDateTime fecha4;
	LocalDateTime fecha5;
	LocalDateTime fecha6;
	
	//LISTAS
	List<Viaje> listaDeViajesTest;
	List<Viaje> listaDeViajesTest2;
	List<Viaje> listaVaciaTest;
	List<Viaje> listaHongKongBsYMonteLima;	
	// Viajes
	Viaje viajeBsAsSanPabloMonteVideo;
	Viaje viajeAsuncionLimaSantiago;
	Viaje viajeLimaSantiagoLaPaz;
	Viaje viajeBsAsMontevideoLima;
	Viaje viajeSanPabloMontevideoLima;
	Viaje viajeHongKongBsAs;
	
	
	@BeforeEach
	void setUp() throws Exception {
		LocalDateTime fecha4 = LocalDateTime.of(2023, 11, 22, 10, 30);
		LocalDateTime fecha1 = LocalDateTime.of(2023, 10, 22, 10, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2023, 9, 22, 10, 30);
		LocalDateTime fecha3 = LocalDateTime.of(2023, 8, 22, 10, 30);
		viajeBsAsSanPabloMonteVideo = mock(Viaje.class);
		viajeAsuncionLimaSantiago = mock(Viaje.class);
		viajeLimaSantiagoLaPaz = mock(Viaje.class);
		viajeBsAsMontevideoLima = mock(Viaje.class);
		viajeSanPabloMontevideoLima = mock(Viaje.class);
		viajeHongKongBsAs = mock(Viaje.class);
		listaVaciaTest = new ArrayList<>();
		listaHongKongBsYMonteLima = new ArrayList<>();
		listaDeViajesTest = new ArrayList<>();
		listaDeViajesTest2 = new ArrayList<>();
		bsAs = mock(TerminalPortuaria.class);
		lima = mock(TerminalPortuaria.class);
		montevideo = mock(TerminalPortuaria.class);
		santiago = mock(TerminalPortuaria.class);
		laPaz = mock(TerminalPortuaria.class);
		when(viajeHongKongBsAs.getFechaDeLlegada()).thenReturn(fecha1);
		when(viajeBsAsSanPabloMonteVideo.getFechaDeLlegada()).thenReturn(fecha2);
		when(viajeAsuncionLimaSantiago.getFechaDeLlegada()).thenReturn(fecha3);
		when(viajeLimaSantiagoLaPaz.getFechaDeLlegada()).thenReturn(fecha4);
		when(viajeBsAsMontevideoLima.getFechaDeLlegada()).thenReturn(fecha1);
		when(viajeSanPabloMontevideoLima.getFechaDeLlegada()).thenReturn(fecha5);
		listaDeViajesTest.add(viajeHongKongBsAs);
		listaDeViajesTest.add(viajeBsAsSanPabloMonteVideo);
		listaDeViajesTest.add(viajeAsuncionLimaSantiago);
		listaDeViajesTest.add(viajeLimaSantiagoLaPaz);
		listaDeViajesTest.add(viajeBsAsMontevideoLima);
		listaHongKongBsYMonteLima.add(viajeHongKongBsAs);
		listaHongKongBsYMonteLima.add(viajeBsAsMontevideoLima);
		listaDeViajesTest2.add(viajeBsAsSanPabloMonteVideo);
		listaDeViajesTest2.add(viajeAsuncionLimaSantiago);
		listaDeViajesTest2.add(viajeLimaSantiagoLaPaz);
		filtroFecha1 = new FiltroFechaLlegada(fecha1);
		
		
	}
	
	@Test
	void busquedaDestinoBsAs() {
		assertEquals(filtroFecha1.filtrar(listaDeViajesTest) , listaHongKongBsYMonteLima);

	}
	
	@Test
	void busquedaDestinoBsAsNoExistente() {
		assertEquals(filtroFecha1.filtrar(listaDeViajesTest2) , listaVaciaTest);

	}
	
	@Test
	void lanzarErrorAlAgregarUnComponente() throws Exception
	{
		Exception error = assertThrows( Exception.class, () -> 
		{
			filtroFecha1.Agregar(filtroFecha1);
		} );
		
		assertEquals( "No Valido", error.getMessage() );
	}
	
	@Test
	void removerNoHaceCambioDeEstado() {
		LocalDateTime fecha1 = LocalDateTime.of(2023, 10, 22, 10, 30);
		filtroFecha1.Remover(filtroFecha1);
		assertEquals(filtroFecha1.getFechaLlegada(), fecha1);
	}

	

}
