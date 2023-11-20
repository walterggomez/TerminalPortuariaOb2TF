package TerminalPortuaria.Ob2TF.Buque;

import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Inbound implements EstadoBuque{


	
	@Override
	public void actualizarEstado(Buque buque) {
		if (buque.getPosicionActual() == buque.puertoDestino().getUbicacion() ) {
			buque.setestadoBuque(new Arrived());
		}
	}

}
