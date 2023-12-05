package TerminalPortuaria.Ob2TF.Buque;

import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Cliente.Suscriptor;
import TerminalPortuaria.Ob2TF.Container.Container;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.EmpresaTransportista;
import TerminalPortuaria.Ob2TF.Servicios.AlmacenamientoExcedente;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Departing implements EstadoBuque 
{

	@Override
    public void actualizarEstado(Buque buque) 
	{
        if (this.distanciaATerminal(buque) > 1.0) 
        	{
            buque.setestadoBuque(new Outbound());
            buque.getViajeActual().getpuertoOrigen().darAvisoShippers( buque.getViajeActual() );

        	}      
        }
    
	public double distanciaATerminal(Buque buque)
	{
		//Implementacion de distancia buque a terminal
		return 100;
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

	@Override
	public void evaluar(Buque buque) {
		// TODO Auto-generated method stub
		
	}




}