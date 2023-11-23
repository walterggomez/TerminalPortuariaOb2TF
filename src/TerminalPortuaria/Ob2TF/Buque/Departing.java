package TerminalPortuaria.Ob2TF.Buque;

import java.util.List;

import TerminalPortuaria.Ob2TF.Cliente.Suscriptor;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Departing implements EstadoBuque {

	@Override
    public void actualizarEstado(Buque buque) {
        if (buque.getMiGps().distanciaEntrePuntos(buque.getPosicionActual(),
                buque.puertoOrigen().getUbicacion()) > 1) 
        {
            buque.avisarTerminalPortuaria(buque.getViajeActual().getpuertoOrigen(), buque.getViajeActual().getShippers(), "Su carga ha salido de la terminal");
            buque.setestadoBuque(new Outbound());
            
        }
    }
	
	
	@Override
	public boolean estoyEnEstado(String string)
	{
		if (string == "Departing")
		{
			return true;
		} else 
		{
			return false;
		}
	}

}