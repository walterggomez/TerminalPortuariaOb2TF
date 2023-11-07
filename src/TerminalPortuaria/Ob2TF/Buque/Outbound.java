package TerminalPortuaria.Ob2TF.Buque;
import java.awt.geom.Point2D;
import TerminalPortuaria.Ob2TF.Circuito.*;

public class Outbound implements EstadoBuque
{
	@Override
	public void actualizarEstado(Buque buque)
	{
		if( GPS.distanciaEntrePuntos( buque.getPosicionActual(), buque.getViajeActual().getCircuito().puertoDestinoCircuito().getUbicacion() ) < 50 )
		{
			// Dar aviso a la terminal
			
			// La terminal debe enviar un mail a los consignees que están esperando el buque, (orden de importación de ese viaje)
				
			buque.actualizarEstado( new Inbound() );
		}
	}
	
}


