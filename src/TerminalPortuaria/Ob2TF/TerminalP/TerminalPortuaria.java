package TerminalPortuaria.Ob2TF.TerminalP;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.Orden.*;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.BusquedaMaritima.*;
import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Container.Container;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Camion;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Chofer;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.EmpresaTransportista;
import TerminalPortuaria.Ob2TF.EstrategiaMejorRuta.MejorRuta;



public class TerminalPortuaria
{
	private String nombre;
	private Point2D  ubicacion;
	private List<Naviera> misNavieras = new ArrayList<Naviera>();
	// private List<Viaje> viajes;
	private Set<Orden> ordenes = new HashSet<Orden>();
	private MejorRuta estrategia;

	
	public TerminalPortuaria() {}

	public TerminalPortuaria(String nombre, Point2D ubicacion)
	{
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.misNavieras = new ArrayList<Naviera>();
		// this.viajes = new ArrayList<Viaje>(); // No debería ser un atributo. Debería pedirle a la lista de Navieras los viajes en los que la termianal está incluída.
		this.ordenes = new HashSet<Orden>();
	}

	public Point2D getUbicacion()
	{
		return this.ubicacion;
	}


	public List<Naviera> getMisNavieras()
	{
		return this.misNavieras;
	}
 
	
	public List<Viaje> getMisViajes()
	{
	    return this.misNavieras.stream()
	            .flatMap(n -> n.getViajes().stream()) // Convierte los sets de viajes de todas las navieras en un solo stream
	            .filter(viaje -> viaje.validarSiTerminalExisteEnViaje(this)) // Filtra los viajes que contienen la terminal
	            .collect( Collectors.toList() ); // Recolecta los viajes en una lista.
	}
	

//	public OrdenExportacion generarOrdenExportacion( Cliente cliente, Viaje viaje, Container container, EmpresaTransportista empresa,
//			boolean servicioLavado)
//	{
//		return new OrdenExportacion( cliente, viaje, container, empresa, servicioLavado );
//	}
//
//	
//	public OrdenImportacion generarOrdenImportacion( Cliente cliente, Viaje viaje, Container container, EmpresaTransportista empresa,
//			boolean servicioLavado)
//	{
//		return new OrdenImportacion( cliente, viaje, container, empresa, servicioLavado );
//	}

	
	public void darAvisoShippers( Viaje viaje )
	{
		List<Orden> ordenesExportacion = ordenes.stream().filter( o -> o.esOrdenExportacion() ).toList();
		List<Cliente> listaConsignees = ordenesExportacion.stream().filter( o -> o.getViaje() == viaje ).map( v -> v.getCliente() ).toList();
		
		listaConsignees.stream().forEach( c -> c.recibirMail("Su carga está llegando") );
	}
	
	public void darAvisoConsignees( Viaje viaje )
	{
		List<Orden> ordenesImportacion = ordenes.stream().filter( o -> o.esOrdenImportacion() ).toList();
		List<Cliente> listaConsignees = ordenesImportacion.stream().filter( o -> o.getViaje() == viaje ).map( v -> v.getCliente() ).toList();
		listaConsignees.stream().forEach( c -> c.recibirMail("Su carga ha salido de la terminal") );
	}
	
	public void enviarFacturaOrden( Viaje viaje )
	{
		List<Orden> ordenesVinculadasAlViaje = this.ordenes.stream().filter( o -> o.getViaje() == viaje ).toList();
		ordenesVinculadasAlViaje.forEach( o -> o.enviarFacturaPorMail() );
	}
	
	
	public void registrasNuevaOrden(Orden orden)
	{
		this.ordenes.add(orden);
	}

	
	public void registrarNuevaNaviera(Naviera nav)
	{
		if ( this.estoyEnUnCircuitoDeLaNaviera(nav) ) 
		{
			this.misNavieras.add(nav);		
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
		buque.trabajando();
	}
	
	public void depart(Buque buque) 
	{
		//posible verificacion de estado working
		//DEBE AVISAR DIRECTO AL ESTADO O AL BUQUE?
		buque.partiendo();
		// Orden debe establecer llegada del container
	}
	
	
	
	public void entregaTerrestreExp(Orden orden, Camion camion, Chofer chofer) throws Exception 
	{
		this.validarCamion(camion, orden);
		this.validarChofer(chofer, orden);
		this.validarHorarioDeEntrega(orden);
		orden.registrarEntregaContainer();
	}
	
	
	public void validarEntregaTerrestreImp(Orden orden, Camion camion, Chofer chofer) throws Exception 
	{
		this.validarCamion(camion, orden);
		this.validarChofer(chofer, orden);
		orden.registrarSalidaContainer();
	}

	
	public void validarHorarioDeEntrega(Orden orden) throws Exception 
	{
		if (ChronoUnit.HOURS.between(orden.getCliente().getTurno(), LocalDateTime.now()) > 3)
		//if ( Math.abs (orden.getCliente().getTurno().getHour() - LocalDateTime.now().getHour()) > 3 )
			// Está mal que el cliente tenga el horario de entrega. Debería tenerlo la propia orden porque un cliente puede tener multiples ordenes.
		{
			throw new Exception ("Llegaste tarde");
		}
	}
	
	
	public void validarChofer(Chofer chofer, Orden orden) throws Exception {
		if ( chofer.getNombre() != orden.getChoferAsignado().getNombre() ) 
		{
			throw new Exception ("El chofer no coincide");
		}
	}
	
	public void validarCamion(Camion camion, Orden orden) throws Exception 
	{
		if ( camion.getPatente() != orden.getCamionAsignado().getPatente() ) 
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
	 

	 public Set<Orden> getOrdenes() 
	 {
		return ordenes;
	}

	 
}