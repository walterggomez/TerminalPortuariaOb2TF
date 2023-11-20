package TerminalPortuaria.Ob2TF.Buque;

import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Outbound implements EstadoBuque{

	

	@Override
	public void actualizarEstado(Buque buque) {
		if (GPS.distanciaEntrePuntos(buque.getPosicionActual(), buque.puertoDestino().getUbicacion()) < 50) {
			buque.avisarTerminalPortuaria(buque.getViajeActual().getpuertoDestino());
			buque.setestadoBuque(new Inbound());
		}
	}

}
