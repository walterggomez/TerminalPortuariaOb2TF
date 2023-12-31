package TerminalPortuaria.Ob2TF.BusquedaMaritimaTest;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import TerminalPortuaria.Ob2TF.Circuito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.BusquedaMaritima.Componente;
import TerminalPortuaria.Ob2TF.BusquedaMaritima.FiltroPuertoDestino;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class FiltroPuertoDestinoTest {

	FiltroPuertoDestino filtroDestinoBsAs;
	FiltroPuertoDestino filtroDestinoLima;
	
	TerminalPortuaria bsAs;
	TerminalPortuaria lima;
	TerminalPortuaria montevideo;
	TerminalPortuaria santiago;
	TerminalPortuaria laPaz;
	
	
	
	//LISTAS
	List<Viaje> listaDeViajesTest;
	List<Viaje> listaDeViajesTest2;
	List<Viaje> listaVaciaTest;
	List<Viaje> listaSoloBsAs;	
	// Viajes
	Viaje viajeBsAsSanPabloMonteVideo;
	Viaje viajeAsuncionLimaSantiago;
	Viaje viajeLimaSantiagoLaPaz;
	Viaje viajeBsAsMontevideoLima;
	Viaje viajeSanPabloMontevideoLima;
	Viaje viajeHongKongBsAs;
	
	
	@BeforeEach
	void setUp() throws Exception {
		viajeBsAsSanPabloMonteVideo = mock(Viaje.class);
		viajeAsuncionLimaSantiago = mock(Viaje.class);
		viajeLimaSantiagoLaPaz = mock(Viaje.class);
		viajeBsAsMontevideoLima = mock(Viaje.class);
		viajeSanPabloMontevideoLima = mock(Viaje.class);
		viajeHongKongBsAs = mock(Viaje.class);
		listaVaciaTest = new ArrayList<>();
		listaSoloBsAs = new ArrayList<>();
		listaDeViajesTest = new ArrayList<>();
		listaDeViajesTest2 = new ArrayList<>();
		bsAs = mock(TerminalPortuaria.class);
		lima = mock(TerminalPortuaria.class);
		montevideo = mock(TerminalPortuaria.class);
		santiago = mock(TerminalPortuaria.class);
		laPaz = mock(TerminalPortuaria.class);
		when(viajeHongKongBsAs.getpuertoDestino()).thenReturn(bsAs);
		when(viajeBsAsSanPabloMonteVideo.getpuertoDestino()).thenReturn(montevideo);
		when(viajeAsuncionLimaSantiago.getpuertoDestino()).thenReturn(santiago);
		when(viajeLimaSantiagoLaPaz.getpuertoDestino()).thenReturn(laPaz);
		when(viajeBsAsMontevideoLima.getpuertoDestino()).thenReturn(lima);
		when(viajeSanPabloMontevideoLima.getpuertoDestino()).thenReturn(lima);
		listaDeViajesTest.add(viajeHongKongBsAs);
		listaDeViajesTest.add(viajeBsAsSanPabloMonteVideo);
		listaDeViajesTest.add(viajeAsuncionLimaSantiago);
		listaDeViajesTest.add(viajeLimaSantiagoLaPaz);
		listaDeViajesTest.add(viajeBsAsMontevideoLima);
		listaSoloBsAs.add(viajeHongKongBsAs);
		listaDeViajesTest2.add(viajeBsAsSanPabloMonteVideo);
		listaDeViajesTest2.add(viajeAsuncionLimaSantiago);
		listaDeViajesTest2.add(viajeLimaSantiagoLaPaz);
		filtroDestinoBsAs = new FiltroPuertoDestino(bsAs);
		
		
	}
	
	@Test
	void busquedaDestinoBsAs() {
		assertEquals(filtroDestinoBsAs.filtrar(listaDeViajesTest) , listaSoloBsAs);

	}
	
	@Test
	void busquedaDestinoBsAsNoExistente() {
		assertEquals(filtroDestinoBsAs.filtrar(listaDeViajesTest2) , listaVaciaTest);

	}
	
	@Test
	void lanzarErrorAlAgregarUnComponente() throws Exception
	{
		Exception error = assertThrows( Exception.class, () -> 
		{
			filtroDestinoBsAs.Agregar(filtroDestinoBsAs);
		} );
		
		assertEquals( "No Valido", error.getMessage() );
	}
	
	@Test
	void removerNoHaceCambioDeEstado() {
		filtroDestinoBsAs.Remover(filtroDestinoBsAs);
		assertEquals(filtroDestinoBsAs.getPuertoDestino(), bsAs);
	}

}
