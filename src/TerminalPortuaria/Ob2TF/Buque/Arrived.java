package TerminalPortuaria.Ob2TF.Buque;

import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Arrived implements EstadoBuque
{

	
	@Override
	public void actualizarEstado(Buque buque) {
		buque.setestadoBuque(new Working());
	}


}
