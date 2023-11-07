package TerminalPortuaria.Ob2TF.Buque;
import java.awt.Point;
import TerminalPortuaria.Ob2TF.Circuito.*;

public class Outbound implements EstadoBuque
{
	@Override
	public void actualizarEstado(Buque buque)
	{
		if( GPS.distanciaEntrePuntos( buque.getPosicionActual(), buque.getViajeActual().getCircuito().puertoDestinoCircuito().getUbicacion() ) < 50 )
		{
			buque.actualizarEstado( new Inbound() );
		}
	}
	
}


