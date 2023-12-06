package TerminalPortuaria.Ob2TF.ClienteTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Cliente.Consignee;
import TerminalPortuaria.Ob2TF.Cliente.Shipper;
import TerminalPortuaria.Ob2TF.Orden.Orden;
import TerminalPortuaria.Ob2TF.Orden.OrdenExportacion;
import TerminalPortuaria.Ob2TF.Orden.OrdenImportacion;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class ClienteTest {
	
	Consignee federico;
	Shipper natalia;
	
	LocalDateTime turno;
	
	TerminalPortuaria bsAs;
	Viaje viajeBsAsHongKong;
	
	OrdenExportacion orden1;
	OrdenExportacion orden2;
	OrdenImportacion orden3;
	
	Cliente cliente1;
	
		

	@BeforeEach
	void setUp() throws Exception {
		federico = new Consignee ("Federico",1001);
		natalia = new Shipper ("Natalia",2005);
		turno = LocalDateTime.of(2023, 12, 28, 15, 00);
		
		bsAs = spy(TerminalPortuaria.class);
		viajeBsAsHongKong = mock(Viaje.class);
		
		
		
		orden1= mock(OrdenExportacion.class);
		orden2= mock(OrdenExportacion.class);
			
	}

	@Test
	void getNombreTest() {
		assertEquals("Federico",federico.getNombre());
		assertEquals("Natalia",natalia.getNombre());
	}
	@Test
	void getCodigoClienteTest() {
		assertEquals(1001,federico.getCodigoCliente());
		assertEquals(2005,natalia.getCodigoCliente());
	}

	@Test
	void turnoTest() {
		federico.setTurno(turno);
		assertEquals(turno,federico.getTurno());
		
	}
	@Test
	void recibirMailTest() {
		orden3 = spy(new OrdenImportacion());
		cliente1= spy(new Consignee());			
		bsAs = spy(new TerminalPortuaria("BsAs", null));
		when(orden3.getCliente()).thenReturn(cliente1);
		when(orden3.getViaje()).thenReturn(viajeBsAsHongKong);
		Set<Orden> ordenes = new HashSet<>();
		ordenes.add(orden3);
		bsAs.registrasNuevaOrden(orden3); 
		bsAs.darAvisoConsignees(viajeBsAsHongKong);
		
		verify( cliente1, times(0)).recibirMail("Su carga está llegando");
		
	}


}
