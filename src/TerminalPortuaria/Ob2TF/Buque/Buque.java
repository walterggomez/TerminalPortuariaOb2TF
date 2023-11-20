package TerminalPortuaria.Ob2TF.Buque;
import java.awt.geom.Point2D;
import TerminalPortuaria.Ob2TF.Circuito.*;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;



public class Buque
{
	private Point2D  posicionActual = new Point2D.Double(0, 0);
	protected EstadoBuque estadoActual = new Outbound();
	private Viaje viajeActual;
	private boolean sePuedeDescargar = false;
	
	/*
	public Buque()
	{
		this.posicionActual =  new Point (0, 0);
	}
	*/
	
	//ASD

	public Viaje getViajeActual()
	{
		return viajeActual;
		
	}
	
	public TerminalPortuaria puertoDestino() {
		return viajeActual.getpuertoDestino();
	}


	public void setViajeActual(Viaje viajeActual)
	{
		this.viajeActual = viajeActual;
	}


	public Point2D getPosicionActual()
	{
		return posicionActual;
	}

	
	public void setPosicionActual(int x, int y)
	{
		this.posicionActual.setLocation(x, y);
	}
	
	
	public void actualizarEstado() {
		this.estadoActual.actualizarEstado(this);
	}
	
	public void setestadoBuque(EstadoBuque estado) {
		this.estadoActual = estado;
	}
	
	public void avisarTerminalPortuaria(TerminalPortuaria puertoGestionado){
		puertoGestionado.avisarClientes();
	}
	
	public void setsePuedeDescargar() {
		this.sePuedeDescargar = true;
	}
	
	public boolean getsePuedeDescargar() {
		return this.sePuedeDescargar;
	}
	
	
}
