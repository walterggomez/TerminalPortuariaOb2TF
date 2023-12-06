package TerminalPortuaria.Ob2TF.Buque;

import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Outbound implements EstadoBuque {


	@Override
	public void actualizarEstado(Buque buque)
	{
			buque.setestadoBuque( new Inbound() );
			buque.getViajeActual().getpuertoDestino().darAvisoConsignees( buque.getViajeActual() );
	}


	public void evaluar(Buque buque, TerminalPortuaria puertoGestionado) 
	{
		if (this.distanciaATerminal(buque,puertoGestionado) < 50) 
		{
			this.actualizarEstado(buque);
		}
	}


	public double distanciaATerminal(Buque buque, TerminalPortuaria puertoGestionado) {
		// TODO Auto-generated method stub
		return buque.getMiGps().distanciaEntrePuntos(buque.getPosicionActual(), puertoGestionado.getUbicacion());
	}

	
}
