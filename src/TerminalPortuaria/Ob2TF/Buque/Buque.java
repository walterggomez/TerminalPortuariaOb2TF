package TerminalPortuaria.Ob2TF.Buque;
import java.awt.Point;
import TerminalPortuaria.Ob2TF.Circuito.*;



public class Buque
{
	private Point  posicionActual = new Point(0, 0);
	EstadoBuque estadoActual = new Outbound();
	private Viaje viajeActual;
	
	/*
	public Buque()
	{
		this.posicionActual =  new Point (0, 0);
	}
	*/

	public Viaje getViajeActual()
	{
		return viajeActual;
	}


	public void setViajeActual(Viaje viajeActual)
	{
		this.viajeActual = viajeActual;
	}


	public Point getPosicionActual()
	{
		return posicionActual;
	}

	
	public void setPosicionActual(int x, int y)
	{
		this.posicionActual.setLocation(x, y);
	}
	
	
	public void actualizarEstado( EstadoBuque estadoActual )
	{
		estadoActual.actualizarEstado(this);
	}	
}
