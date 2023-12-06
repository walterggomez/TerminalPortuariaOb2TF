package TerminalPortuaria.Ob2TF.Buque;

import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Inbound implements EstadoBuque {

	@Override
	public void actualizarEstado(Buque buque) 
	{
			buque.setestadoBuque(new Arrived());
	}
	
	public double distanciaATerminal(Buque buque, TerminalPortuaria puertoGestionado) {
		return buque.getMiGps().distanciaEntrePuntos(buque.getPosicionActual(), puertoGestionado.getUbicacion());
	}


	@Override
	public void evaluar(Buque buque, TerminalPortuaria puertoGestionado) {
		if (this.distanciaATerminal(buque, puertoGestionado) == 0) {
			this.actualizarEstado(buque);
		}
		
	}



}
