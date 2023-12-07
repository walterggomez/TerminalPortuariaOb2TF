package TerminalPortuaria.Ob2TF.Orden;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

class OrdenTestII 
{
	EmpresaTransportista expresoLider;
	TransporteAsignado transporteAsignadoI;
	TransporteAsignado transporteAsignadoII;
	Camion scaniaI;
	Chofer redBarclay;
	
	Camion scaniaII;
	Chofer homeroSimpson;
	
	
	Consignee albertoFernandez;
	
	
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
	Circuito circuitoMock;
	
	
	Viaje viajePrincipal;
	Viaje viajeMock;

	
	// Listas
	List<Tramo> listaDeTramosPrincipal;
	
	
	// Servicios
	Lavado lavado;
	Pesado pesado;
	Electricidad electricidad;
	Set<Servicios> setServicios;
	
	
	// Ordenes
	OrdenExportacion ordenExportacion;
	OrdenImportacion ordenImportacion;
	OrdenImportacion ordenSpy;
	
	
	// Containers
	Dry containerDry;
	Reefer containerReefer;
	Tanque containerTanque;
	
	Reefer containerReeferMock;
	
	
	// Buques
	Buque buqueBus;
	Buque titanic;
	Buque araSanJuan;
	
	// Facturas
	Factura facturaI;
	
	
	
	
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
		
		circuitoMock = mock( Circuito.class );
		when( circuitoMock.costoTotalDelCircuito() ).thenReturn(0.0);
		
		
		
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// VIAJES
		
		viajePrincipal = spy( new Viaje( buqueBus, circuitoPrincipal, LocalDateTime.of(2023, 12, 01, 13, 00) ) );
		
		
		viajeMock = mock( Viaje.class );
		when( viajeMock.cantidadEscalas() ).thenReturn(1);
		when( viajeMock.costoViaje() ).thenReturn(50.0);
		when( viajeMock.getCircuito() ).thenReturn(circuitoMock);
		

//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// BUQUES
		
		buqueBus = spy( new Buque( new Point2D.Double(-23.5475, -46.63611), new GPS(), viajePrincipal ) );
		titanic = spy( new Buque( new Point2D.Double(-23.5475, -46.63611), new GPS(), viajePrincipal ) );
		araSanJuan = spy( new Buque( new Point2D.Double(-23.5475, -46.63611), new GPS(), viajePrincipal ) );
		
		
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// SERVICIOS
		


		lavado = mock( Lavado.class );
		when( lavado.costoServicio(ordenSpy) ).thenReturn(100.0);
		
		
		pesado = mock( Pesado.class );
		when( pesado.costoServicio(ordenSpy) ).thenReturn(100.0);
		
		electricidad = mock( Electricidad.class );
		when( electricidad.costoServicio(ordenSpy) ).thenReturn(100.0);
		
		setServicios = Set.of(lavado, pesado, electricidad);
		
//		setServicios = new HashSet<Servicios>();
//		// 	protected Set<Servicios> servicios = new HashSet<Servicios>();
//		setServicios.add(electricidad);
//		setServicios.add(pesado);
//		setServicios.add(lavado);
		
		
		
		
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// CONTAINERS
		
		containerDry = spy( new Dry( 5, 5, 5, 5 ) );
		containerReefer = spy( new Reefer( 5, 5, 5, 5 ) );
		containerTanque = spy( new Tanque( 5, 5, 5, 5 ) );
		
		containerReeferMock = mock( Reefer.class );

		
		
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// EMPRESA TRANSPORTISTA
		
		expresoLider = spy( new EmpresaTransportista() );
		expresoLider.agregarNuevoCamion(scaniaI);
		expresoLider.agregarNuevoCamion(scaniaII);
		
		expresoLider.agregarNuevoChofer(homeroSimpson);
		expresoLider.agregarNuevoChofer(redBarclay);
	
		
		
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// TRANSPORTE ASIGNADO
		transporteAsignadoI = spy( new TransporteAsignado() );
		when( transporteAsignadoI.getChoferAsignado() ).thenReturn(homeroSimpson);
		when( transporteAsignadoI.getCamionAsignado() ).thenReturn(scaniaI);
		when( transporteAsignadoI.getCliente() ).thenReturn(albertoFernandez);
		
		
		transporteAsignadoII = spy( new TransporteAsignado() );
		when( transporteAsignadoII.getChoferAsignado() ).thenReturn(redBarclay);
		when( transporteAsignadoII.getCamionAsignado() ).thenReturn(scaniaII);
		when( transporteAsignadoII.getCliente() ).thenReturn(albertoFernandez);
		
		
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// CLIENTES
		
		albertoFernandez = spy( new Consignee("Alberto", 5) );

		
		
//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		// ORDENES
		
		ordenImportacion = new OrdenImportacion( albertoFernandez, viajePrincipal, containerReefer, expresoLider, true );
		ordenImportacion.registrarSalidaContainer();

		// when( ordenImportacion.getTransporteAsignado() ).thenReturn(transporteAsignadoI);
		
		
		
		ordenExportacion = new OrdenExportacion( albertoFernandez, viajePrincipal, containerTanque, expresoLider, false );
		ordenExportacion.registrarEntregaContainer();

		
		ordenSpy = spy ( new OrdenImportacion( albertoFernandez, viajeMock, containerReeferMock, expresoLider, false ) );
		// when( ordenSpy.getViaje() ).thenReturn(viajePrincipal);
		
		ordenSpy.registrarEntregaContainer();
		ordenSpy.registrarSalidaContainer();
		
		
		// when( ordenSpy.getViaje().costoViaje() ).thenReturn(100.0);
		// when( ordenSpy.viaje.getCircuito().costoTotalDelCircuito() ).thenReturn(100.0);
		
		


		

		
		//		public LocalDateTime getEntregaContainer() 
//		{
//			return entregaContainer;
//		}
//
//		public LocalDateTime getSalidaContainer() 
//		{
//			return salidaContainer;
//		}
		
		
	}


	
	@Test
	void precioTotalDeOrdenSpy()
	{

		when( lavado.costoServicio(ordenSpy) ).thenReturn(100.0);
		when( pesado.costoServicio(ordenSpy) ).thenReturn(100.0);
		when( electricidad.costoServicio(ordenSpy) ).thenReturn(100.0);
		
		setServicios = Set.of(lavado, pesado, electricidad);
		ordenSpy.setServicios(setServicios);
	
		assertEquals( 300, ordenSpy.precioTotal() );
		assertEquals( 3, ordenSpy.getServicios().size() );
	}
	
	@Test
	void generoFacturaOrdenImportacion()
	{
		Factura facturaI = ordenImportacion.generarFactura();
		// verify(facturaI, times(1) ).agregarCostoCircuito();
		assertTrue( facturaI instanceof Factura );
	}
	

}








