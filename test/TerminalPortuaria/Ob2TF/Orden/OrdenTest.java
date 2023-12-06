package TerminalPortuaria.Ob2TF.Orden;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Container;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Orden.*;
import TerminalPortuaria.Ob2TF.Servicios.*;
import TerminalPortuaria.Obj2TF.Factura.Factura;
import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Container.Dry;
import TerminalPortuaria.Ob2TF.Container.Reefer;
import TerminalPortuaria.Ob2TF.Container.Tanque;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.EmpresaTransportista;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.TransporteAsignado;

class OrdenTest {
	
	OrdenExportacion ordenEx;
	OrdenExportacion ordenExPrueba;
	OrdenImportacion orden;
	OrdenImportacion ordenImpPrueba;
	Dry containerDry;
	Factura factura;
	Reefer containerReefer;
	Tanque containerTanque;
	Viaje viaje;
	Cliente cliente;
	EmpresaTransportista plumar;
	TransporteAsignado transporteAsig;
	Servicios servicio;
	Electricidad electricidad;
	Lavado lavado;
	Pesado pesado;
	AlmacenamientoExcedente almacenamientoExcedente;
	Set<Servicios> setEvaluador;
	AlmacenamientoExcedente servicioEx;
	Circuito circuito1;
	
	@BeforeEach
	void setUp() throws Exception {
		containerDry = mock(Dry.class);
		containerReefer = mock(Reefer.class);
		containerTanque = mock (Tanque.class);
		almacenamientoExcedente = spy(AlmacenamientoExcedente.class );
		electricidad = spy(Electricidad.class);
		pesado = spy(Pesado.class);
		lavado = spy(Lavado.class);
		circuito1 = mock(Circuito.class);
		setEvaluador = new HashSet<>();
		transporteAsig = mock(TransporteAsignado.class);
		factura = mock(Factura.class);
		viaje = mock(Viaje.class);
		cliente = spy(Cliente.class);
		plumar = mock(EmpresaTransportista.class);
		LocalDateTime fecha1 = LocalDateTime.of(2023, 10, 22, 10, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2023, 12, 22, 10, 30);
		setEvaluador.add(almacenamientoExcedente);
		setEvaluador.add(lavado);
		setEvaluador.add(pesado);
		
		
		when(viaje.getFechaDeSalida()).thenReturn(fecha1);
		when(viaje.getFechaDeLlegada()).thenReturn(fecha2);
		
		orden = new OrdenImportacion(cliente,viaje,containerDry,plumar,false);
		ordenEx = new OrdenExportacion(cliente,viaje,containerReefer, plumar, true);

		

		
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
//		assertEquals(ordenExPrueba.precioTotal(), 1000);
//	}
	
	@Test
	void conseguirCodigoUnico() {
		assertTrue(orden.getCodigoUnico() instanceof UUID);
	}
	
	
	@Test
	void servicioElectricidad() {
		assertEquals(null, orden.getServicioElectricidad());
	}
	
	@Test
	void servicioElectricidadEx() {
		assertTrue(ordenEx.getServicioElectricidad() instanceof Electricidad);
	}
	
	@Test
	void servicioLavado() {
		assertEquals(null, orden.getServicioLavado());
	}
	
	@Test
	void servicioLavadoEx() {
		ordenEx = spy(new OrdenExportacion(cliente,viaje,containerReefer, plumar, true));
		assertEquals(3,ordenEx.getServicios().size());
		ordenEx.evaluarServicioLavado();
		assertEquals(4,ordenEx.getServicios().size());
		}
	
	@Test
	void servicioPesado() {
		assertEquals(null, orden.getServicioPesado());
	}
	
	@Test
	void servicioAlmacenamiento() {
		assertTrue(orden.getServicioAlmacenamientoExcedente() instanceof AlmacenamientoExcedente);
	}
	
	@Test
	void esOrdenDeImportacion() {
		assertTrue(orden.esOrdenImportacion());
	}
	
	@Test
	void esOrdenDeExportacion() {
		assertFalse(orden.esOrdenExportacion());
	}
	
	@Test
	void esOrdenDeImportacion2() {
		assertFalse(ordenEx.esOrdenImportacion());
	}
	
	@Test
	void esOrdenDeExportacion2() {
		assertTrue(ordenEx.esOrdenExportacion());
	}
	
	
}
