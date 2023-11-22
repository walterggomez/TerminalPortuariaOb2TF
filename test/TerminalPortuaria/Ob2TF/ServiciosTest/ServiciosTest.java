package TerminalPortuaria.Ob2TF.ServiciosTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Container.Container;
import TerminalPortuaria.Ob2TF.Orden.Orden;
import TerminalPortuaria.Ob2TF.Servicios.AlmacenamientoExcedente;
import TerminalPortuaria.Ob2TF.Servicios.Electricidad;
import TerminalPortuaria.Ob2TF.Servicios.Lavado;
import TerminalPortuaria.Ob2TF.Servicios.Pesado;

class ServiciosTest {

	Electricidad servElectrico;
	AlmacenamientoExcedente servAlmacenamiento;
	Lavado servLavado;
	Pesado servPesado;

	Container container1;

	Orden ordenNro1;
	LocalDateTime salidaContainer;
	LocalDateTime entregaContainer;

	@BeforeEach
	void setUp() throws Exception {
		servElectrico = new Electricidad();
		servAlmacenamiento = new AlmacenamientoExcedente();
		servLavado = new Lavado();
		servPesado = new Pesado();
		container1 = mock(Container.class);

		ordenNro1 = mock(Orden.class);

	}

	@Test
	void servicioDeElectricidadTest() {
		assertEquals(50, servElectrico.getCostoKwHora());
		servElectrico.setCostoKwHora(100);
		assertEquals(100, servElectrico.getCostoKwHora());
		salidaContainer = LocalDateTime.of(2023, 12, 18, 13, 00);
		entregaContainer = LocalDateTime.of(2023, 12, 28, 15, 00);
		when(ordenNro1.getSalidaContainer()).thenReturn(salidaContainer);
		when(ordenNro1.getEntregaContainer()).thenReturn(entregaContainer);
		assertEquals(24200, servElectrico.costoServicio(ordenNro1));

	}

	@Test
	void servicioDeAlmacenamientoExcedenteTest() {
		assertEquals(50, servAlmacenamiento.getCostoPorDia());
		servAlmacenamiento.setCostoPorDia(100);
		assertEquals(100, servAlmacenamiento.getCostoPorDia());
		salidaContainer = LocalDateTime.of(2023, 12, 18, 13, 00);
		entregaContainer = LocalDateTime.of(2023, 12, 28, 15, 00);
		when(ordenNro1.getSalidaContainer()).thenReturn(salidaContainer);
		when(ordenNro1.getEntregaContainer()).thenReturn(entregaContainer);
		assertEquals(24200, servAlmacenamiento.costoServicio(ordenNro1));
	}

	@Test
	void servicioDeLavadoVolumenMenorA70Test() {
		when(ordenNro1.getContainer()).thenReturn(container1);
		when(container1.volumen()).thenReturn(60);
		assertEquals(100,servLavado.costoServicio(ordenNro1));
			
	}

	@Test
	void servicioDeLavadoVolumenMayorA70Test() {
		when(ordenNro1.getContainer()).thenReturn(container1);
		when(container1.volumen()).thenReturn(80);
		assertEquals(30,servLavado.costoServicio(ordenNro1));
		
	}

	@Test
	void servicioDePesadoTest() {
		assertEquals(50, servPesado.getCostoPesaje());
		servPesado.setCostoPesaje(100);
		assertEquals(100, servPesado.getCostoPesaje());
		assertEquals(100, servPesado.costoServicio(ordenNro1));

	}

}
