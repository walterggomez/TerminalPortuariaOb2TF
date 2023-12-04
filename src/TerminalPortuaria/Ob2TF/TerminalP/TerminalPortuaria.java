package TerminalPortuaria.Ob2TF.TerminalP;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.Orden.Orden;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.BusquedaMaritima.*;
import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Cliente.Suscriptor;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Camion;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Chofer;
import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.MejorRuta;



public class TerminalPortuaria
{
	private String nombre;
	private Point2D  ubicacion;
	private List<Naviera> misNavieras;
	private List<Viaje> viajes;
	private List<Orden> ordenes;
	private MejorRuta estrategia;

	
	public TerminalPortuaria() {
		
	}

	public TerminalPortuaria(String nombre, Point2D ubicacion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.misNavieras = new ArrayList<Naviera>();
		this.viajes = new ArrayList<Viaje>();
		this.ordenes = new ArrayList<Orden>();
	}

	public Point2D getUbicacion()
	{
		return ubicacion;
	}


	public List<Naviera> getMisNavieras()
	{
		return misNavieras;
	}

	

	public List<Viaje> getMisViajes()
	{
		return viajes;
	}
	
	public void registrasNuevaOrden(Orden orden) {
		//VERIFICAR SI NECESITA VALIDACION
		this.ordenes.add(orden);
	}

	public void registrarNuevaNaviera(Naviera nav) {
		if (this.estoyEnUnCircuitoDeLaNaviera(nav)) {
			this.getMisNavieras().add(nav);
		}else{
			System.out.println("Naviera no valida para registrar");			
		}
		
	}

	public boolean estoyEnUnCircuitoDeLaNaviera(Naviera nav) 
	{
		List<Circuito> circuitosNaviera = nav.getMisCircuitos();
		return circuitosNaviera.stream().anyMatch(cir->cir.validarSiTerminalExisteEnCircuito(this));
	}
	
	public void trabajoCargaYDescarga(Buque buque)
	{
		//posible verificacion de estado arrived
		//DEBE AVISAR DIRECTO AL ESTADO O AL BUQUE?
		buque.getEstadoActual().actualizarEstado(buque);
	}
	
	public void depart(Buque buque) 
	{
		//posible verificacion de estado working
		//DEBE AVISAR DIRECTO AL ESTADO O AL BUQUE?
		buque.getEstadoActual().actualizarEstado(buque);
		// Orden debe establecer llegada del container
	}
	
	
	public void avisarClientes( Viaje viaje, List<Suscriptor> listaSuscriptores, String mensaje ) 
	{
		viaje.notify( listaSuscriptores, mensaje );
	}
	
	/*
	 		Facturación:
	 			puerto destino
	 			
	 */
	
	//CONVERTIR LISTA DE ORDENES A LISTA DE CLIENTES
	private List<Orden> filtrarLista(Viaje viaje) 
	{
		return this.ordenes.stream().filter( v -> v.getViaje().getBuqueViaje() == viaje.getBuqueViaje()).toList();
	}
	
	/*
	public double emitirFactura( Cliente cliente, Orden orden )
	{
		
	*/
	
	private void validarEntregaTerrestreExp(Orden orden, Camion camion, Chofer chofer) throws Exception 
	{
		this.validarCamion(camion, orden);
		this.validarChofer(chofer, orden);
		this.validarHorarioDeEntrega(orden);
		orden.registrarEntregaContainer();
	}
	
	private void validarEntregaTerrestreImp(Orden orden, Camion camion, Chofer chofer) throws Exception 
	{
		this.validarCamion(camion, orden);
		this.validarChofer(chofer, orden);
		orden.registrarSalidaContainer();
	}
	
	private void validarHorarioDeEntrega(Orden orden) throws Exception 
	{
		if ( orden.getCliente().getTurno().getHour() - LocalDateTime.now().getHour() > 3 ) 
		{
			throw new Exception ("Llegaste tarde");
		}
	}
	
	private void validarChofer(Chofer chofer, Orden orden) throws Exception {
		if ( chofer.getNombre() != orden.getTransporteAsignado().getChoferAsignado().getNombre() ) 
		{
			throw new Exception ("El chofer no coincide");
		}
	}
	
	private void validarCamion(Camion camion, Orden orden) throws Exception 
	{
		if ( camion.getPatente() != orden.getTransporteAsignado().getCamionAsignado().getPatente() ) 
		{
			throw new Exception ("El camión no coincide");
		}
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	
	 public void setMejorCircuito( MejorRuta estrategia )
	 {
	 	this.estrategia = estrategia;
	 }
	 
	 
	 public Circuito getMejorCircuito(TerminalPortuaria terminalDestino)
	 {
	 	return this.estrategia.mejorCircuito(this, terminalDestino);
	 }
	 

	 public List<Orden> getOrdenes() 
	 {
		return ordenes;
	}

	 public Orden buscarOrdenPorBuqueYViaje(Viaje viaje, Buque buque) 
	 {
		    return this.getOrdenes()
		            .stream()
		            .filter(o -> o.getViaje().equals(viaje) && o.getViaje().getBuqueViaje().equals(buque))
		            .findFirst()
		            .orElse(null);
		}

	 




}