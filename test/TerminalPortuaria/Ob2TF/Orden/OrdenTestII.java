package TerminalPortuaria.Ob2TF.Orden;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// importamos los otros paquetes
import TerminalPortuaria.Obj2TF.Factura.*;
import TerminalPortuaria.Ob2TF.TerminalP.*;
import TerminalPortuaria.Ob2TF.Buque.*;
import TerminalPortuaria.Ob2TF.Circuito.*;
import TerminalPortuaria.Ob2TF.Cliente.*;
import TerminalPortuaria.Ob2TF.Container.*;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.*;
import TerminalPortuaria.Ob2TF.Naviera.*;
import TerminalPortuaria.Ob2TF.Servicios.*;


//public Orden(Cliente cliente, Viaje viaje, Container container, EmpresaTransportista empresa, boolean servicioLavado)
//{
//	this.cliente = cliente;
//	this.viaje = viaje;
//	this.container = container;
//	this.transporteAsignado = empresa.asignarTransporte(this);
//	this.servicioLavado = servicioLavado;
//	this.evaluarServicioLavado();
//	this.evaluarServicioReefer();
//	this.codigoUnico = UUID.randomUUID();
//}

//public OrdenExportacion( Cliente cliente, Viaje viaje, Container container, EmpresaTransportista empresa, boolean servicioLavado)
//{
//	super( cliente, viaje, container, empresa, servicioLavado );
//	servicios.add( new Pesado() );
//	this.salidaContainer = viaje.getFechaDeSalida();
//}

//public OrdenImportacion( Cliente cliente, Viaje viaje, Container container, EmpresaTransportista empresa, boolean servicioLavado)
//{
//	super( cliente, viaje, container, empresa, servicioLavado );
//	servicios.add( new AlmacenamientoExcedente() );
//	this.entregaContainer = viaje.getFechaDeLlegada();
//}

/*
		Dependencias:
		Cliente y sus atributos... entre otras cosas el turno que debería ser en realidad de la propia orden.
		Empresa transportista, camiones, choferes y transporte asignado...
 */


class OrdenTestII 
{
	EmpresaTransportista expresoLider;
	Camion scaniaI;
	Chofer redBarclay;
	
	Camion scaniaII;
	Chofer homeroSimpson;
	
	
	Cliente albertoFernandez;
	
	
	// Declaraciones tramos, circuitos y viajes.
	// Puertos
	TerminalPortuaria bsAs;
	TerminalPortuaria saoPablo;
	TerminalPortuaria montevideo;
	TerminalPortuaria asuncion;
	TerminalPortuaria lima;
	TerminalPortuaria santiagoDeChile;
	TerminalPortuaria laPaz;
	
	
	Tramo bsAsSaoPablo;
	Tramo saoPabloMontevideo;
	Tramo montevideoAsuncion;
	Tramo asuncionLima; 
	Tramo limaSantiagoDeChile;
	Tramo santiagoDeChileLaPaz;
	
	
	Circuito circuitoPrincipal;
	
	
	Viaje viajePrincipal;

	
	// Listas
	List<Tramo> listaDeTramosPrincipal;
	
	
	// Ordenes
	OrdenExportacion ordenExportacion;
	OrdenImportacion ordenImportacion;
	
	
	// Containers
	Dry containerDry;
	Reefer containerReefer;
	Tanque containerTanque;
	
	
	// Buques
	Buque buqueBus;
	Buque titanic;
	Buque araSanJuan;
	
	
	
	
	@BeforeEach
	void setUp() throws Exception 
	{
	
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// TERMINALES
		
		// Terminal gestionada
		bsAs = spy( new TerminalPortuaria( "Buenos Aires", new Point2D.Double(-34.61315, -58.37723) ) );
		
		// Mocks del resto de las terminales
		saoPablo = mock(TerminalPortuaria.class);
		montevideo = mock(TerminalPortuaria.class);
		asuncion = mock(TerminalPortuaria.class);
		lima = mock(TerminalPortuaria.class);
		santiagoDeChile = mock(TerminalPortuaria.class);
		laPaz = mock(TerminalPortuaria.class);
		
		// getUbicacion() de las terminales
		when(saoPablo.getUbicacion()).thenReturn( new Point2D.Double(-23.5475, -46.63611) );
		when(montevideo.getUbicacion()).thenReturn( new Point2D.Double(-34.90328, -56.18816) );
		when(asuncion.getUbicacion()).thenReturn( new Point2D.Double(-25.28646, -57.647) );
		when(lima.getUbicacion()).thenReturn( new Point2D.Double(-12.04318, -77.02824) );
		when(santiagoDeChile.getUbicacion()).thenReturn( new Point2D.Double(-33.45694, -70.64827) );
		when(laPaz.getUbicacion()).thenReturn( new Point2D.Double(-16.5, -68.15) );
		
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// TRAMOS
		

// public Tramo(TerminalPortuaria puertoOrigen, TerminalPortuaria puertoDestino, LocalDateTime fechaYHoraSalida, double costoDetramo,  double duracionTramo)
		
		// Spy de los tramos del circuito 1°
		bsAsSaoPablo = spy( new Tramo( bsAs, saoPablo, LocalDateTime.now(), 100, 1) );
		saoPabloMontevideo = spy( new Tramo( saoPablo, montevideo, LocalDateTime.now(), 100, 1) );
		montevideoAsuncion = spy( new Tramo( montevideo, asuncion, LocalDateTime.now(), 100, 1) );
		asuncionLima = spy( new Tramo( asuncion, lima, LocalDateTime.now(), 100, 1) );
		limaSantiagoDeChile = spy( new Tramo( lima, santiagoDeChile, LocalDateTime.now(), 100, 1) );
		santiagoDeChileLaPaz = spy( new Tramo( santiagoDeChile, laPaz, LocalDateTime.now(), 100, 1) );
		
		// Lista tramo
		listaDeTramosPrincipal = new ArrayList<Tramo>(Arrays.asList
				( 
						bsAsSaoPablo, saoPabloMontevideo, montevideoAsuncion, asuncionLima, limaSantiagoDeChile, santiagoDeChileLaPaz
				)
		);
		
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// CIRCUITOS
		
		circuitoPrincipal = spy( new Circuito( listaDeTramosPrincipal, LocalDateTime.now() ) );
		
		
		
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// VIAJES
		
		viajePrincipal = spy( new Viaje(  ) );
		
		// 	public Viaje( Buque buqueViaje, Circuito circuitoViaje, LocalDateTime fechaDeSalida)
		// 	public Buque(Point2D posicionActual, GPS miGps, Viaje viajeActual)
	
	
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// BUQUES
		
		buqueBus = mock( Buque.class);
		
	
	
	
	
	
	
	}

	@Test
	void test()
	{
		
		fail("Not yet implemented");
	}

}
