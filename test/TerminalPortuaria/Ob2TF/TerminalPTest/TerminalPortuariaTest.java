package TerminalPortuaria.Ob2TF.TerminalPTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Buque.Buque.*;
import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Circuito.Tramo;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Cliente.Consignee;
import TerminalPortuaria.Ob2TF.Cliente.Shipper;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Camion;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Chofer;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.TransporteAsignado;
import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.MejorRuta;
import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.*;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.Orden.Orden;
import TerminalPortuaria.Ob2TF.Orden.OrdenExportacion;
import TerminalPortuaria.Ob2TF.Orden.OrdenImportacion;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class TerminalPortuariaTest
{

	// Circuitos
	Circuito circuito1;
	Circuito circuito2;
	Circuito circuito3;
	Circuito circuito4;
	
	
	// Puertos
	TerminalPortuaria bsAs;
	TerminalPortuaria saoPablo;
	TerminalPortuaria montevideo;
	TerminalPortuaria asuncion;
	TerminalPortuaria lima;
	TerminalPortuaria santiagoDeChile;
	TerminalPortuaria laPaz;

	
	// Tramos que conforman circuito 1°.
	Tramo bsAsSaoPablo;
	Tramo saoPabloMontevideo;
	Tramo montevideoAsuncion;
	Tramo asuncionLima; 
	Tramo limaSantiagoDeChile;
	Tramo santiagoDeChileLaPaz;
	
	// Tramos que conforman cirucito 2°
	Tramo saoPabloLima;
	// Tramo limaSantiagoDeChile; 
	Tramo santiagoDeChileMontevideo; 
	Tramo montevideoBsAs;
	Tramo bsAsLaPaz;
	Tramo laPazAsuncion;
	
	// Tramos que conforman circuito 3°
	Tramo limaBsAs;
	Tramo bsAsSantiagoDeChile;
	Tramo santiagoDeChileAsuncion;
	Tramo asuncionSaoPablo;
	// Tramo saoPabloMontevideo;
	Tramo montevideoLaPaz;
	
	// Listas de tramos
	List<Tramo> listaTramosNro1;
	List<Tramo> listaTramosNro2;
	List<Tramo> listaTramosNro3;
	List<Tramo> listaTramosNro4;
	List<Tramo> listaTramosReducida;
	List<Tramo> listaTramosSinDefinir;
	
	// Listas de circuitos
	List<Circuito> listaCircuitosNaviera1;
	List<Circuito> listaCircuitosNaviera2;
	List<Circuito> listaCircuitosSinDefinir;
	
	// Lista naviera
	List<Naviera> listaNaviera;
	List<Naviera> listaNavierasSinDefinir;
	
	
	
	// Navieras
	Naviera naviera1;
	Naviera naviera2;
	Naviera naviera3;
	Naviera naviera4;
	
	// Buques
	Buque buque1;
	Buque buque2;
	Buque buque3;
	Buque buque4;
	
	// Set de los buques
	Set<Buque> setBuques;
	
	
	// Viaje
	Viaje viajeCircuito1PrimeraFecha;
	Viaje viajeCircuito1Reducido;
	Viaje viajeCircuito1SegundaFecha;
	Viaje viajeCircuito2;
	Viaje viajeCircuito3;
	
	Viaje viajeLunaNueva;

	
	// Orden
	OrdenImportacion ordenImportacion;
	OrdenExportacion ordenExportacion;
	
	OrdenExportacion ordenExp1;
	OrdenExportacion ordenExp2;
	OrdenImportacion ordenImp1;
	OrdenImportacion ordenImp2;
	
	List<Orden> ordenes;
	
	
	//Estrategia
	MenorCantidadTerminal estrategiaMenorCantidad;
	MenorPrecio estrategiaMenorPrecio;
	MenorTiempo estrategiaMenorTiempo;
	
	//Cliente
	Cliente cliente;
	
	Consignee meJodes;	
	Shipper meJodes2;
	
	
	@BeforeEach
	void setUp() throws Exception 
	{
		// Mocks de las terminales
		bsAs = spy( TerminalPortuaria.class );
		// bsAs = new TerminalPortuaria();
		saoPablo = mock(TerminalPortuaria.class);
		montevideo = mock(TerminalPortuaria.class);
		asuncion = mock(TerminalPortuaria.class);
		lima = mock(TerminalPortuaria.class);
		santiagoDeChile = mock(TerminalPortuaria.class);
		laPaz = mock(TerminalPortuaria.class);
		
		//mock cliente
		cliente = mock(Cliente.class);
		
		//mock de estrategia
		estrategiaMenorCantidad = mock(MenorCantidadTerminal.class);
		estrategiaMenorPrecio = mock(MenorPrecio.class);
		estrategiaMenorTiempo = mock(MenorTiempo.class);
		
		
		// getUbicacion() de las terminales
		when(bsAs.getUbicacion()).thenReturn( new Point2D.Double(-34.61315, -58.37723) );
		when(saoPablo.getUbicacion()).thenReturn( new Point2D.Double(-23.5475, -46.63611) );
		when(montevideo.getUbicacion()).thenReturn( new Point2D.Double(-34.90328, -56.18816) );
		when(asuncion.getUbicacion()).thenReturn( new Point2D.Double(-25.28646, -57.647) );
		when(lima.getUbicacion()).thenReturn( new Point2D.Double(-12.04318, -77.02824) );
		when(santiagoDeChile.getUbicacion()).thenReturn( new Point2D.Double(-33.45694, -70.64827) );
		when(laPaz.getUbicacion()).thenReturn( new Point2D.Double(-16.5, -68.15) );
		
		//getNombre
		when(bsAs.getNombre()).thenReturn("Puerto Buenos Aires");
		
		// Mock buques
		buque1 = mock( Buque.class );
		buque2 = mock( Buque.class );
		buque3 = mock( Buque.class );
		buque4 = mock( Buque.class );
		
		
		// Spy de los tramos del circuito 1°
		bsAsSaoPablo = spy( new Tramo() );
		saoPabloMontevideo = spy( new Tramo() );
		montevideoAsuncion = spy( new Tramo() );
		asuncionLima = spy( new Tramo() );
		limaSantiagoDeChile = spy( new Tramo() );
		santiagoDeChileLaPaz = spy( new Tramo() );
		
		// Spy de los tramos del circuito 2°
		saoPabloLima = spy( new Tramo() );
		// limaSantiagoDeChile = spy( new Tramo() );
		santiagoDeChileMontevideo = spy( new Tramo() );
		montevideoBsAs = spy( new Tramo() );
		bsAsLaPaz = spy( new Tramo() );
		laPazAsuncion = spy( new Tramo() );
		
		// Spy de los tramos del circuito 3°
		limaBsAs = spy( new Tramo() );
		bsAsSantiagoDeChile = spy( new Tramo() );
		santiagoDeChileAsuncion = spy( new Tramo() );
		asuncionSaoPablo = spy( new Tramo() );
		// saoPabloMontevideo = spy( new Tramo() );
		montevideoLaPaz = spy( new Tramo() );
		

		// Tramo a agregar, sin continuidad con el último puerto del circuito
		asuncionSaoPablo = spy( Tramo.class );
		when( asuncionSaoPablo.getPuertoOrigen() ).thenReturn(asuncion);
		when( asuncionSaoPablo.getPuertoDestino() ).thenReturn(saoPablo);
		
		
		// Tramo a agregar el cual coincide con el último puerto del circuito
		laPazAsuncion = spy( Tramo.class );
		when( laPazAsuncion.getPuertoOrigen() ).thenReturn(laPaz);
		when( laPazAsuncion.getPuertoDestino() ).thenReturn(asuncion);
		
		

		
		

//		╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		
		// Comportamiento de los tramos circuito 1°
		
		// Puertos
		when( bsAsSaoPablo.getPuertoOrigen() ).thenReturn(bsAs);
		when( bsAsSaoPablo.getPuertoDestino() ).thenReturn(saoPablo);
		
		when( saoPabloMontevideo.getPuertoOrigen() ).thenReturn(saoPablo);
		when( saoPabloMontevideo.getPuertoDestino() ).thenReturn(montevideo);
		
		when( montevideoAsuncion.getPuertoOrigen() ).thenReturn(montevideo);
		when( montevideoAsuncion.getPuertoDestino() ).thenReturn(asuncion);
		
		when( asuncionLima.getPuertoOrigen() ).thenReturn(asuncion);
		when( asuncionLima.getPuertoDestino() ).thenReturn(lima);
		
		when( limaSantiagoDeChile.getPuertoOrigen() ).thenReturn(lima);
		when( limaSantiagoDeChile.getPuertoDestino() ).thenReturn(santiagoDeChile);
		
		when( santiagoDeChileLaPaz.getPuertoOrigen() ).thenReturn(santiagoDeChile);
		when( santiagoDeChileLaPaz.getPuertoDestino() ).thenReturn(laPaz);
		
		// Duración de los tramos del circuito 1°
		when( bsAsSaoPablo.getDuracionTramo() ).thenReturn(1.0);
		when( saoPabloMontevideo.getDuracionTramo() ).thenReturn(1.0);
		when( montevideoAsuncion.getDuracionTramo() ).thenReturn(1.0);
		when( asuncionLima.getDuracionTramo() ).thenReturn(1.0);
		when( limaSantiagoDeChile.getDuracionTramo() ).thenReturn(1.0);
		when( santiagoDeChileLaPaz.getDuracionTramo() ).thenReturn(1.0);		

		// Costos de los tramos del circuito 1°
		when( bsAsSaoPablo.getCostoDetramo() ).thenReturn(1.0);
		when( saoPabloMontevideo.getCostoDetramo() ).thenReturn(1.0);
		when( montevideoAsuncion.getCostoDetramo() ).thenReturn(1.0);
		when( asuncionLima.getCostoDetramo() ).thenReturn(1.0);
		when( limaSantiagoDeChile.getCostoDetramo() ).thenReturn(1.0);
		when( santiagoDeChileLaPaz.getCostoDetramo() ).thenReturn(1.0);
		
//					╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		
		// Comportamiento de los tramos circuito 2°
		
		// Puertos
		when( saoPabloLima.getPuertoOrigen() ).thenReturn(saoPablo);
		when( saoPabloLima.getPuertoDestino() ).thenReturn(lima);
		
//		when( limaSantiagoDeChile.getPuertoOrigen() ).thenReturn(lima);
//		when( limaSantiagoDeChile.getPuertoDestino() ).thenReturn(santiagoDeChile);
		
		when( santiagoDeChileMontevideo.getPuertoOrigen() ).thenReturn(santiagoDeChile);
		when( santiagoDeChileMontevideo.getPuertoDestino() ).thenReturn(montevideo);
		
		when( montevideoBsAs.getPuertoOrigen() ).thenReturn(montevideo);
		when( montevideoBsAs.getPuertoDestino() ).thenReturn(bsAs);
		
		when( bsAsLaPaz.getPuertoOrigen() ).thenReturn(bsAs);
		when( bsAsLaPaz.getPuertoDestino() ).thenReturn(laPaz);
		
		when( laPazAsuncion.getPuertoOrigen() ).thenReturn(laPaz);
		when( laPazAsuncion.getPuertoDestino() ).thenReturn(asuncion);
		
		// Duración
		when( saoPabloLima.getDuracionTramo() ).thenReturn(1.0);
//		when( limaSantiagoDeChile.getDuracionTramo() ).thenReturn(1.0);
		when( santiagoDeChileMontevideo.getDuracionTramo() ).thenReturn(1.0);
		when( montevideoBsAs.getDuracionTramo() ).thenReturn(1.0);
		when( bsAsLaPaz.getDuracionTramo() ).thenReturn(1.0);
		when( laPazAsuncion.getDuracionTramo() ).thenReturn(1.0);
		
		// Costos
		when( saoPabloLima.getCostoDetramo() ).thenReturn(1.0);
//		when( limaSantiagoDeChile.getCostoDetramo() ).thenReturn(1.0);
		when( santiagoDeChileMontevideo.getCostoDetramo() ).thenReturn(1.0);
		when( montevideoBsAs.getCostoDetramo() ).thenReturn(1.0);
		when( bsAsLaPaz.getCostoDetramo() ).thenReturn(1.0);
		when( laPazAsuncion.getCostoDetramo() ).thenReturn(1.0);
		
//					╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		
		// Comportamiento de los tramos circuito 3°
		
		// Puertos
		when( limaBsAs.getPuertoOrigen() ).thenReturn(lima);
		when( limaBsAs.getPuertoDestino() ).thenReturn(bsAs);
		
		when( bsAsSantiagoDeChile.getPuertoOrigen() ).thenReturn(bsAs);
		when( bsAsSantiagoDeChile.getPuertoDestino() ).thenReturn(santiagoDeChile);
		
		when( santiagoDeChileAsuncion.getPuertoOrigen() ).thenReturn(santiagoDeChile);
		when( santiagoDeChileAsuncion.getPuertoDestino() ).thenReturn(asuncion);
		
		when( asuncionSaoPablo.getPuertoOrigen() ).thenReturn(asuncion);
		when( asuncionSaoPablo.getPuertoDestino() ).thenReturn(saoPablo);
		
//		when( saoPabloMontevideo.getPuertoOrigen() ).thenReturn(saoPablo);
//		when( saoPabloMontevideo.getPuertoDestino() ).thenReturn(montevideo);
		
		when( montevideoLaPaz.getPuertoOrigen() ).thenReturn(montevideo);
		when( montevideoLaPaz.getPuertoDestino() ).thenReturn(laPaz);		

		// Duración
		when( limaBsAs.getDuracionTramo() ).thenReturn(1.0);
		when( bsAsSantiagoDeChile.getDuracionTramo() ).thenReturn(1.0);
		when( santiagoDeChileAsuncion.getDuracionTramo() ).thenReturn(1.0);
		when( asuncionSaoPablo.getDuracionTramo() ).thenReturn(1.0);
//		when( saoPabloMontevideo.getDuracionTramo() ).thenReturn(1.0);
		when( montevideoLaPaz.getDuracionTramo() ).thenReturn(1.0);
		
		// Costos
		when( bsAsSaoPablo.getCostoDetramo() ).thenReturn(1.0);
		when( saoPabloMontevideo.getCostoDetramo() ).thenReturn(1.0);
		when( montevideoAsuncion.getCostoDetramo() ).thenReturn(1.0);
		when( asuncionLima.getCostoDetramo() ).thenReturn(1.0);
		when( limaSantiagoDeChile.getCostoDetramo() ).thenReturn(1.0);
		when( santiagoDeChileLaPaz.getCostoDetramo() ).thenReturn(1.0);
		
//					╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		
		// *** Listas ***
		
		// Lista de tramos 1°
		// Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		listaTramosNro1 = new ArrayList<Tramo>(Arrays.asList
				( 
						bsAsSaoPablo, saoPabloMontevideo, montevideoAsuncion, asuncionLima, limaSantiagoDeChile, santiagoDeChileLaPaz
				)
		);
		
		
		listaTramosNro2 = new ArrayList<Tramo>(Arrays.asList
				( 
						saoPabloLima, limaSantiagoDeChile, santiagoDeChileMontevideo, montevideoBsAs, bsAsLaPaz, laPazAsuncion
				)
		);
		
		
		listaTramosNro3 = new ArrayList<Tramo>(Arrays.asList
				( 
						limaBsAs, bsAsSantiagoDeChile, santiagoDeChileAsuncion, asuncionSaoPablo, saoPabloMontevideo, montevideoLaPaz
				)
		);
		

		listaTramosNro4 = new ArrayList<Tramo>(Arrays.asList
				( 
						santiagoDeChileAsuncion, asuncionSaoPablo, saoPabloMontevideo, montevideoLaPaz
				)
		);
		

		
			
		// Lista de tramos nro 1° reducida a dos tramos
		listaTramosReducida = new ArrayList<Tramo>
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						montevideoAsuncion, asuncionLima
				)
		);
		
		

	
		// Spy de los circuitos
		circuito1 = spy( new Circuito(listaTramosNro1, LocalDateTime.now()) );
		circuito2 = spy( new Circuito(listaTramosNro2, LocalDateTime.now()) );
		circuito3 = spy( new Circuito(listaTramosNro3, LocalDateTime.now()) );
		circuito4 = spy( new Circuito( listaTramosNro4, LocalDateTime.now()) ); // No contiene a bsAs
		
		
		listaCircuitosNaviera1 = new ArrayList<Circuito>
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						circuito1, circuito2
				)
		);
		
		
		listaCircuitosNaviera2 = new ArrayList<Circuito>
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						circuito3
				)
		);
		


		
		

		
		
		// Set de los buques
		setBuques = Set.of(buque1, buque2, buque3);
		
		// Navieras 1
		naviera1 = spy( new Naviera() );
		doReturn(setBuques).when(naviera1).getMisBuques();
		
		// Naviera 2
		naviera2 = spy( new Naviera() );
		when( naviera2.getMisCircuitos() ).thenReturn( listaCircuitosNaviera2 );
		doReturn(setBuques).when(naviera2).getMisBuques();
		
		// Naviera 3
		naviera3 = spy( new Naviera() );		
		
		
		//Generacion de orden
		ordenImportacion = spy(OrdenImportacion.class);
		ordenExportacion = spy(OrdenExportacion.class);
	
		//Generacion de orden
//		when(bsAs.generarOrdenExportacion(null, viajeCircuito1PrimeraFecha, null, null, false)).thenReturn(ordenExportacion);
//		when(bsAs.generarOrdenImportacion(null, viajeCircuito1PrimeraFecha, null, null, false)).thenReturn(ordenImportacion);
		
		
	}
	
	//
	
	@Test
	void naviera2PoseeLosCircuitosDeLaLista()
	{
		assertEquals( naviera2.getMisCircuitos(), listaCircuitosNaviera2 );
	}
	
	@Test
	void naviera1AgregaUnViajeASuLista() throws Exception
	{
		naviera1.agregarCircuito(circuito1);
		naviera1.agregarCircuito(circuito2);
		naviera1.establecerViaje(buque1, LocalDateTime.now(), circuito1);
		assertFalse( naviera1.getViajes().isEmpty() );
	}
	
	@Test
	void registrarOrden() {
		bsAs.registrasNuevaOrden(ordenExportacion);
		assertTrue(bsAs.getOrdenes().contains(ordenExportacion));
	}
	
	@Test
	void conseguirNombre() {
		assertEquals("Puerto Buenos Aires",bsAs.getNombre());
	}

	@Test
	public void setDeEstragia() {
		bsAs.setMejorCircuito(estrategiaMenorCantidad);
		when(estrategiaMenorCantidad.mejorCircuito(bsAs, asuncion)).thenReturn(circuito1);
		assertEquals(circuito1, bsAs.getMejorCircuito(asuncion));
	}
	
	@Test
	void errorAlValidarBuque()
	{
		Exception error = assertThrows( Exception.class, () -> 
		{
			naviera1.validarBuque(buque4);
		} );
		
		assertEquals( "Este buque no existe en la naviera", error.getMessage() );
	}
	
	@Test
	void errorAlValidarCircuito()
	{
		naviera1.agregarCircuito(circuito1);
		naviera1.agregarCircuito(circuito2);
		Exception error = assertThrows( Exception.class, () -> 
		{
			naviera1.validarCircuito(circuito3);
		} );
		
		assertEquals( "Este circuito no se encuentra en las ofertas de la naviera", error.getMessage() );
	}
	
	@Test
	void validarQueNoSeAgregueUnCircuitoRepetido()
	{
		naviera1.agregarCircuito(circuito1);
		naviera1.agregarCircuito(circuito1);
		assertEquals( 1, naviera1.getMisCircuitos().size() );
	}
	
	@Test
	void validarSiTerminalEstaEnCircuitoDeNaviera()
	{
		naviera1.agregarCircuito(circuito1);
		assertTrue( bsAs.estoyEnUnCircuitoDeLaNaviera(naviera1) );
		// assertTrue( circuito1.validarSiTerminalExisteEnCircuito(bsAs) );
	}
	
	@ Test
	void agregarNavieraATerminal()
	{
		naviera1.agregarCircuito(circuito1);
		bsAs.registrarNuevaNaviera(naviera1);
		assertEquals( 1, bsAs.getMisNavieras().size() );
	}


	@Test
	void alAgregarNavieraQueNoContieneATerminalNoOcurreNada()
	{
		bsAs.registrarNuevaNaviera(naviera3);
		assertEquals( 0, bsAs.getMisNavieras().size() );
	}
	
	
	@Test
	void corroboroQueSeLlameAMetodoDeBuqueTrabjando()
	{
		bsAs.trabajoCargaYDescarga(buque1);
		verify( buque1, times(1) ).trabajando();
	}
	
	@Test
	void corroboroQueSeLlameAMetodoDeBuquePartiendo()
	{
		bsAs.depart(buque1);
		verify( buque1, times(1) ).partiendo();
	}
	
	@Test
	void corroboroQueTerminalGestionadaContengaViajesDeSusNavieras() throws Exception
	{
		// Corroboro la existencia o no de bsAs en los circuitos
		assertTrue( circuito1.validarSiTerminalExisteEnCircuito(bsAs) );
		assertTrue( circuito2.validarSiTerminalExisteEnCircuito(bsAs) );
		assertTrue( circuito3.validarSiTerminalExisteEnCircuito(bsAs) );
		assertFalse( circuito4.validarSiTerminalExisteEnCircuito(bsAs) );
		
		listaCircuitosSinDefinir = new ArrayList<Circuito>(Arrays.asList
				( 
						circuito1, circuito2, circuito3, circuito4
				)
		);
		
		
		naviera1.agregarCircuito(circuito1);
		naviera1.agregarCircuito(circuito2);
		naviera1.agregarCircuito(circuito3);
		naviera1.agregarCircuito(circuito4);
		assertEquals( 4, naviera1.getMisCircuitos().size() );
		assertEquals( listaCircuitosSinDefinir, naviera1.getMisCircuitos() );
		
		
		// Comprobar que naviera registre bien los viajes.
		naviera1.establecerViaje(buque1, LocalDateTime.now(), circuito1);
		naviera1.establecerViaje(buque1, LocalDateTime.now(), circuito2);
		naviera1.establecerViaje(buque1, LocalDateTime.now(), circuito3);
		naviera1.establecerViaje(buque1, LocalDateTime.now(), circuito4);
		assertEquals( 4, naviera1.getViajes().size() );
		
		
		// Comprobar que registre bien la naviera.
		listaNaviera = new ArrayList<Naviera>(Arrays.asList( naviera1 ));
		bsAs.registrarNuevaNaviera(naviera1);
		assertEquals( 1, bsAs.getMisNavieras().size() );
		assertEquals( listaNaviera, bsAs.getMisNavieras() );
		
		
		// Compruebo que bsAs tenga 3 viajes, correspondientes a los 3 viajes cuyos circuitos contienen a bsAs ...
		assertEquals( 3, bsAs.getMisViajes().size() );
	}
	
	
	@Test
	void validarHorarioDeEntregaFueTarde() {
		LocalDateTime turno = LocalDateTime.of(1980, 12, 18, 13, 00);
		when(ordenExportacion.getCliente()).thenReturn(cliente);
		when(cliente.getTurno()).thenReturn(turno);
		Exception error = assertThrows( Exception.class, () -> 
		{
			bsAs.validarHorarioDeEntrega(ordenExportacion);
		} );
		assertEquals( "Llegaste tarde", error.getMessage() );
	}
	
	@Test
	void validarQueChoferNoCoincide() {
		TransporteAsignado transporte = mock(TransporteAsignado.class);
		Chofer chofer1 = mock(Chofer.class);
		when(chofer1.getNombre()).thenReturn("Carlos");
		Chofer chofer2 = mock(Chofer.class);
		when(chofer2.getNombre()).thenReturn("Raul");
		when(transporte.getChoferAsignado()).thenReturn(chofer1);
		when(ordenExportacion.getTransporteAsignado()).thenReturn(transporte);
		Exception error = assertThrows( Exception.class, () -> 
		{
			bsAs.validarChofer(chofer2, ordenExportacion);
		} );
		assertEquals( "El chofer no coincide", error.getMessage() );
	}
	
	@Test
	void validarCamionNoEsElCorrecto() {
		TransporteAsignado transporte = mock(TransporteAsignado.class);
		Camion camion1 = mock(Camion.class);
		when(camion1.getPatente()).thenReturn("ABC");
		Camion camion2 = mock(Camion.class);
		when(camion2.getPatente()).thenReturn("123");
		when(transporte.getCamionAsignado()).thenReturn(camion1);
		when(ordenExportacion.getTransporteAsignado()).thenReturn(transporte);
		Exception error = assertThrows( Exception.class, () -> 
		{
			bsAs.validarCamion(camion2, ordenExportacion);
		} );
		assertEquals( "El camión no coincide", error.getMessage() );
	}
	
	@Test
	void validarQueCumpleLosRequisitos() throws Exception {
		TransporteAsignado transporte = mock(TransporteAsignado.class);
		// LocalDateTime turno = LocalDateTime.of(1980, 12, 18, 01, 00);
		LocalDateTime turno = LocalDateTime.now();
		when(cliente.getTurno()).thenReturn(turno);
		Chofer chofer1 = mock(Chofer.class);
		when(chofer1.getNombre()).thenReturn("Carlos");
		Chofer chofer2 = mock(Chofer.class);
		when(chofer2.getNombre()).thenReturn("Carlos");
		Camion camion1 = mock(Camion.class);
		when(camion1.getPatente()).thenReturn("ABC");
		Camion camion2 = mock(Camion.class);
		when(camion2.getPatente()).thenReturn("ABC");
		when(transporte.getCamionAsignado()).thenReturn(camion1);
		when(transporte.getChoferAsignado()).thenReturn(chofer1);
		when(ordenExportacion.getTransporteAsignado()).thenReturn(transporte);
		when(ordenExportacion.getCliente()).thenReturn(cliente);
		when(ordenImportacion.getTransporteAsignado()).thenReturn(transporte);
		when(ordenImportacion.getCliente()).thenReturn(cliente);
		bsAs.entregaTerrestreExp(ordenExportacion, camion2, chofer2);
		verify( ordenExportacion, times(1) ).registrarEntregaContainer();
		bsAs.validarEntregaTerrestreImp(ordenImportacion, camion2, chofer2);
		verify( ordenImportacion, times(1) ).registrarSalidaContainer();
		
	}
	
	@Test
	void darAvisoConsignees() {
		
		ordenExp1 = spy(new OrdenExportacion());
		ordenExp2 = spy(new OrdenExportacion());
		ordenImp1 = spy(new OrdenImportacion());
		ordenImp2 = spy(new OrdenImportacion());
		viajeLunaNueva = spy(Viaje.class);
		meJodes = spy(new Consignee("Carlos", 0));
		when(ordenImp1.getViaje()).thenReturn(viajeLunaNueva);
		when(ordenImp1.getCliente()).thenReturn(meJodes);
		bsAs.registrasNuevaOrden(ordenExp1);
		bsAs.registrasNuevaOrden(ordenExp2);
		bsAs.registrasNuevaOrden(ordenImp1);
		bsAs.registrasNuevaOrden(ordenImp2);
		bsAs.darAvisoConsignees(viajeLunaNueva);
		verify(meJodes, times(1) ).recibirMail("Su carga ha salido de la terminal");
		}
	
	@Test
	void darAvisoShipper() {
		
		ordenExp1 = spy(new OrdenExportacion());
		ordenExp2 = spy(new OrdenExportacion());
		ordenImp1 = spy(new OrdenImportacion());
		ordenImp2 = spy(new OrdenImportacion());
		viajeLunaNueva = spy(Viaje.class);
		meJodes2 = spy(new Shipper("Pepe",0));
		when(ordenExp1.getViaje()).thenReturn(viajeLunaNueva);
		when(ordenExp1.getCliente()).thenReturn(meJodes2);
		bsAs.registrasNuevaOrden(ordenExp1);
		bsAs.registrasNuevaOrden(ordenExp2);
		bsAs.registrasNuevaOrden(ordenImp1);
		bsAs.registrasNuevaOrden(ordenImp2);
		bsAs.darAvisoShippers(viajeLunaNueva);
		verify(meJodes2, times(1) ).recibirMail("Su carga está llegando");
		}
}	


//	
//	TerminalPortuaria bsAs;
//	TerminalPortuaria saoPablo;
//	
//	Point2D latitudLongitudBsAs;
//	Point2D latitudLongitudSaoPablo;
//	
//	Naviera naviera1; // [circuito1, circuito2, circuito3]
//	Naviera naviera2;
//	
//	Circuito circuito1; // [tramo1,tramo2,tramo3]-> bsAs - saoPablo - busan - hongKong
//	Circuito circuito2; // [tramo4,tramo5,tramo6]-> bsAs - cartagena - shanghai - singapur
//	Circuito circuito3; // [tramo7,tramo8,tramo9]-> bsAs - longBeach - saoPablo - cartagena
//	Circuito circuito4;
//	Circuito circuito5;
//	Circuito circuito6;
//	
//	List<Circuito> circuitosN1;
//	List<Circuito> circuitosN2;
//
//
//	@BeforeEach
//	void setUp() throws Exception{
//		
//		latitudLongitudBsAs = new Point2D.Double(-34.61315, -58.37723);
//		latitudLongitudSaoPablo = new Point2D.Double(-23.5475, -46.63611);
//		
//		
//		bsAs = new TerminalPortuaria("Buenos Aires", latitudLongitudBsAs);
//		saoPablo = new TerminalPortuaria("Sao Pablo", latitudLongitudSaoPablo);
//		
//		naviera1 = mock(Naviera.class);
//		naviera2 = mock(Naviera.class);
//		
//		
//		//Circuito
//		circuito1 = mock(Circuito.class);
//		circuito2 = mock(Circuito.class);
//		circuito3 = mock(Circuito.class);
//		
//		circuito4 = mock(Circuito.class);
//		circuito5 = mock(Circuito.class);
//		circuito6 = mock(Circuito.class);
//		
//		circuitosN1 = Arrays.asList(circuito1, circuito2, circuito3);
//		circuitosN2 = Arrays.asList(circuito4, circuito5, circuito6);
//		
//		when(naviera1.getMisCircuitos()).thenReturn(circuitosN1);
//		when(naviera2.getMisCircuitos()).thenReturn(circuitosN2);
//		

//		
//		when(circuito1.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(true);
//		when(circuito2.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(false);
//		when(circuito3.validarSiTerminalExisteEnCircuito(bsAs)).thenReturn(false);
//		
//		when(circuito4.validarSiTerminalExisteEnCircuito(saoPablo)).thenReturn(false);
//		when(circuito5.validarSiTerminalExisteEnCircuito(saoPablo)).thenReturn(false);
//		when(circuito6.validarSiTerminalExisteEnCircuito(saoPablo)).thenReturn(false);
//		
//	}
//	
//
//	@Test
//	void registrarNuevaNavieraTestOk(){ // se espera resultado valido
//		bsAs.registrarNuevaNaviera(naviera1);
//		assertEquals(1,bsAs.getMisNavieras().size());
//	}
//	@Test
//	void registrarNuevaNavieraTest(){ // se espera resultado NO valido
//		saoPablo.registrarNuevaNaviera(naviera2);
//		assertEquals(0,saoPablo.getMisNavieras().size());
//	}
//	@Test
//	void estoyEnUnCircuitoDeLaNavieraTest(){
//		assertTrue(bsAs.estoyEnUnCircuitoDeLaNaviera(naviera1));
//		assertFalse(saoPablo.estoyEnUnCircuitoDeLaNaviera(naviera1));
//	}
//	@Test
//	void getUbicacionTest(){
//		assertEquals(latitudLongitudBsAs,bsAs.getUbicacion());
//		assertEquals(latitudLongitudSaoPablo,saoPablo.getUbicacion());
//	}
//
//}

