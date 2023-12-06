package TerminalPortuaria.Ob2TF.Buque;

import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Working implements EstadoBuque {

	@Override
	public void actualizarEstado(Buque buque) {
		buque.setestadoBuque(new Departing());
	}


	@Override
	public void evaluar(Buque buque, TerminalPortuaria terminalPortuaria) {
	}





}
