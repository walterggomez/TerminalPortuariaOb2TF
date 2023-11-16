package TerminalPortuaria.Ob2TF.Buque;
import java.awt.geom.Point2D;
import TerminalPortuaria.Ob2TF.Circuito.*;



public class Buque
{
	private Point2D  posicionActual = new Point2D.Double(0, 0);
	EstadoBuque estadoActual = new Outbound();
	private Viaje viajeActual;
	
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
	
	
	public void actualizarEstado( EstadoBuque estadoActual )
	{
		estadoActual.actualizarEstado(this);
	}	
}
