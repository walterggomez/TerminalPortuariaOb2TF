package TerminalPortuariaOb2TF.EmpresaTransportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.EmpresaTransportista.Camion;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Chofer;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.EmpresaTransportista;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.TransporteAsignado;
import TerminalPortuaria.Ob2TF.Orden.Orden;

class EmpresaTransportistaTest {

	
	//EmpresaTransportista
	EmpresaTransportista plumar;
	
	//Ordenes
	Orden orden1;
	Orden orden2;
	Orden orden3;
	
	//Chofer
	Chofer chofer;
	Chofer chofer2;
	Chofer chofer3;
	
	//Camiones
	Camion camion;
	Camion camion2;
	Camion camion3;
	
	//TransporteAsignado
	TransporteAsignado transporte1;
	
	//ListaChoferes
	List<Chofer>  choferes;
	
	
	//ListaCamiones
	List<Camion> camiones;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		orden1 = mock(Orden.class);
		orden2 = mock(Orden.class);
		orden3 = spy(Orden.class);
		
		chofer = mock(Chofer.class);
		chofer2 = mock(Chofer.class);
		chofer3 = mock(Chofer.class);

		
		camion = mock(Camion.class);
		camion2 = mock(Camion.class);
		camion3 = mock(Camion.class);
		
		transporte1 = mock(TransporteAsignado.class);
		
		choferes = new ArrayList<>();
		camiones = new ArrayList<>();
		
		plumar = new EmpresaTransportista ();
		plumar.agregarNuevoCamion(camion);
		plumar.agregarNuevoCamion(camion2);
		plumar.agregarNuevoCamion(camion3);
		plumar.agregarNuevoChofer(chofer);
		plumar.agregarNuevoChofer(chofer2);
		plumar.agregarNuevoChofer(chofer3);
		
		choferes.add(chofer);
		choferes.add(chofer2);
		choferes.add(chofer3);
		
		camiones.add(camion);
		camiones.add(camion2);
		camiones.add(camion3);
		
		when(orden3.getTransporteAsignado()).thenReturn(transporte1);
		
		
		
	}
	
	
	@Test
	void testNoAgregarSiExiste() {
		plumar.agregarNuevoChofer(chofer);
		plumar.agregarNuevoCamion(camion);
		assertEquals(plumar.getCamiones(), camiones);
		assertEquals(plumar.getChoferes(), choferes);
		
	}
	
	@Test
	void asignarTransporte() {
		plumar.asignarTransporte(orden3);
		assertEquals(transporte1, orden3.getTransporteAsignado());
		
	}
	
	

}
