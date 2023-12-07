package TerminalPortuaria.Ob2TF.Buque;
import java.awt.geom.Point2D;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.*;

import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;



public class Buque
{
	//private Point2D  posicionActual = new Point2D.Double(0, 0);
	private Point2D  posicionActual;
	private GPS miGps;
	//protected EstadoBuque estadoActual = new Outbound();
	private EstadoBuque estadoActual;
	private Viaje viajeActual;
	//private boolean sePuedeDescargar = false;
	private boolean sePuedeDescargar;
	
	public Buque() {}
	
	public Buque(Point2D posicionActual, GPS miGps, Viaje viajeActual)
	{
		super();
		this.posicionActual = posicionActual;
		this.miGps = miGps;
		this.estadoActual = new Outbound();
		this.viajeActual = viajeActual;
		this.sePuedeDescargar = false;
	}
 
	public Viaje getViajeActual()
	{
		return viajeActual;
	}

	public GPS getMiGps() {
		return miGps;
	}

	public EstadoBuque getEstadoActual() {
		return estadoActual;
	}

	public TerminalPortuaria puertoDestino() {
		return viajeActual.getpuertoDestino();
	}
	
	public TerminalPortuaria puertoOrigen() {
		return viajeActual.getpuertoOrigen();
	}


	public void setViajeActual(Viaje viajeActual)
	{
		this.viajeActual = viajeActual;
	}

	

	public Point2D getPosicionActual()
	{
		return posicionActual;
	}

	public void setPosicionActual(Point2D posicionActual) {
		this.posicionActual = posicionActual;
	}
	/*public void setPosicionActual(int x, int y)
	{
		this.posicionActual.setLocation(x, y);
	}*/
	

	public void setestadoBuque(EstadoBuque estado) {
		this.estadoActual = estado;
	}
	
//	public void avisarTerminalPortuaria(TerminalPortuaria puertoGestionado, List<Suscriptor> listaSuscriptores, String mensaje)
//	{
//		puertoGestionado.avisarClientes( this.viajeActual,  listaSuscriptores,  mensaje);
//	}
	
	public void setsePuedeDescargar() 
	{
		this.sePuedeDescargar = true;
	}
	
	public boolean getsePuedeDescargar() {
		return this.sePuedeDescargar;
	}
	
	//Este metodo se envia cada 1 minuto y el estado se encarga de evaluar la distancia a la terminal destino
	public void informarPosicion(TerminalPortuaria puertoGestionado) {
		estadoActual.evaluar(this, puertoGestionado);
	}
	
	public void trabajando() {
		this.estadoActual.actualizarEstado(this);
	}
	
	public void partiendo() {
		this.estadoActual.actualizarEstado(this);
	}

	
	
}
