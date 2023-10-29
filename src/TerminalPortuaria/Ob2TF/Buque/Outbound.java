package TerminalPortuaria.Ob2TF.Buque;
import java.awt.Point;

public class Outbound implements EstadoBuque
{
	
	void actualizarEstado(Buque buque)
	{
		if( GPS.distanciaEntrePuntos( buque.getPosicionActual(), buque.getViajeActual().getCircuto.getPuertoDestino() ) < 50 )
		{
			buque.actualizarEstado( new Inbound() );
		}
	}
	
}


