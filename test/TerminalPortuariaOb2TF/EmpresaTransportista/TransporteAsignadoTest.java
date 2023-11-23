package TerminalPortuariaOb2TF.EmpresaTransportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Camion;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Chofer;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.TransporteAsignado;
import TerminalPortuaria.Ob2TF.Orden.Orden;

class TransporteAsignadoTest {

	// TransporteAsignado
	TransporteAsignado transporte1;

	// Chofer
	Chofer chofer;
	Chofer chofer2;
	Chofer chofer3;

	// Camiones
	Camion camion;
	Camion camion2;
	Camion camion3;
	
	//Ordenes
	Orden orden1;
	Orden orden2;
	Orden orden3;
	
	//Cliente
	Cliente cliente1;

	@BeforeEach
	void setUp() throws Exception {
		
		cliente1 = mock(Cliente.class);
		
		orden1 = mock(Orden.class);
		orden2 = mock(Orden.class);
		orden3 = mock(Orden.class);
		
		chofer = mock(Chofer.class);
		chofer2 = mock(Chofer.class);
		chofer3 = mock(Chofer.class);

		
		camion = mock(Camion.class);
		camion2 = mock(Camion.class);
		camion3 = mock(Camion.class);
		
		when(orden1.getCliente()).thenReturn(cliente1);
		
		
		// TransporteAsignado
		transporte1 = new TransporteAsignado(orden1, camion2, chofer);

	}

	@Test
	void seTesteanLosSetters() {
		assertEquals(transporte1.getCamionAsignado(), camion2);
		assertEquals(transporte1.getChoferAsignado(), chofer);
		assertEquals(transporte1.getCliente(), orden1.getCliente());
	}

}
