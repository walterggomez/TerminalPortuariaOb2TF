package TerminalPortuaria.Ob2TF.Orden;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.awt.Container;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Orden.*;
import TerminalPortuaria.Ob2TF.Servicios.AlmacenamientoExcedente;
import TerminalPortuaria.Ob2TF.Servicios.Servicios;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Container.Dry;
import TerminalPortuaria.Ob2TF.Container.Reefer;
import TerminalPortuaria.Ob2TF.Container.Tanque;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.EmpresaTransportista;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.TransporteAsignado;

class OrdenTest {
	
	OrdenImportacion orden;
	Dry containerDry;
	Reefer containerReefer;
	Tanque containerTanque;
	Viaje viaje;
	Cliente cliente;
	EmpresaTransportista plumar;
	TransporteAsignado transporteAsig;
	Servicios servicio;
	List<Servicios> listaEvaluadora;
	AlmacenamientoExcedente servicioEx;
	@BeforeEach
	void setUp() throws Exception {
		containerDry = mock(Dry.class);
		containerReefer = mock(Reefer.class);
		containerTanque = mock (Tanque.class);
		transporteAsig = mock(TransporteAsignado.class);
		viaje = mock(Viaje.class);
		cliente = mock(Cliente.class);
		plumar = mock(EmpresaTransportista.class);
		listaEvaluadora = new ArrayList<>();
		LocalDateTime fecha1 = LocalDateTime.of(2023, 10, 22, 10, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2023, 12, 22, 10, 30);
		when(viaje.getFechaDeSalida()).thenReturn(fecha1);
		when(viaje.getFechaDeLlegada()).thenReturn(fecha2);
		orden = new OrdenImportacion(cliente,viaje,containerDry,plumar,false);
		
	}
	
	

	@Test
	void testGetters() {
		LocalDateTime fecha1 = LocalDateTime.of(2023, 10, 22, 10, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2023, 12, 22, 10, 30);
		assertEquals(orden.getCliente(), cliente);
		assertEquals(orden.getViaje(), viaje);
		assertEquals(orden.getContainer(), containerDry);
		assertEquals(orden.getFechaDeSalidaCarga(), fecha1);
		assertEquals(orden.getFechaDeLlegadaCarga(), fecha2);
	}

	@Test
	void fechasCarga() {
		LocalDateTime fechaPrueba = LocalDateTime.now();
		orden.registrarEntregaContainer();
		orden.registrarSalidaContainer();
		assertEquals(orden.getSalidaContainer(),fechaPrueba );
		assertEquals(orden.getEntregaContainer(),fechaPrueba );
	}
	
//	@Test
//	void costoServicios() {
//		assertEquals(orden.precioTotal(), 1000);
//	}
	
}
