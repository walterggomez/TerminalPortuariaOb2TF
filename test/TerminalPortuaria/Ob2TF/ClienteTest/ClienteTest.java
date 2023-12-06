package TerminalPortuaria.Ob2TF.ClienteTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Cliente.Consignee;
import TerminalPortuaria.Ob2TF.Cliente.Shipper;

import TerminalPortuaria.Ob2TF.Orden.OrdenExportacion;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class ClienteTest {
	
	Consignee federico;
	Shipper natalia;
	
	LocalDateTime turno;
	
	TerminalPortuaria bsAs;
	Viaje viajeBsAsHongKong;
	
	OrdenExportacion orden1;
	OrdenExportacion orden2;
	
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
		cliente1= mock(Cliente.class);			
		bsAs = new TerminalPortuaria();
		bsAs.darAvisoConsignees(viajeBsAsHongKong);
		
		verify( cliente1).recibirMail("Su carga ha salido de la terminal");
		
	}


}
