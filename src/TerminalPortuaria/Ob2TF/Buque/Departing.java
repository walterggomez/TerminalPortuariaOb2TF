package TerminalPortuaria.Ob2TF.Buque;

import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Cliente.Suscriptor;
import TerminalPortuaria.Ob2TF.Container.Container;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.EmpresaTransportista;
import TerminalPortuaria.Ob2TF.Servicios.AlmacenamientoExcedente;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Departing implements EstadoBuque {

	@Override
    public void actualizarEstado(Buque buque) 
	{
        if (buque.getMiGps().distanciaEntrePuntos(buque.getPosicionActual(),
                buque.puertoOrigen().getUbicacion()) > 1) 
        	{
            buque.avisarTerminalPortuaria(buque.getViajeActual().getpuertoOrigen(), buque.getViajeActual().getShippers(), "Su carga ha salido de la terminal");
            buque.setestadoBuque(new Outbound());
        	buque.getViajeActual().unsubscribe(buque.getViajeActual().getShippers(), 
        			buque.puertoOrigen().buscarOrdenPorBuqueYViaje(buque.getViajeActual(), buque).getCliente());
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