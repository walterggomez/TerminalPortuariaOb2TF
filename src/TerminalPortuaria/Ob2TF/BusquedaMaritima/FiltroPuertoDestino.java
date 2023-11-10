package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class FiltroPuertoDestino implements Componente {

	public Viaje esViajeConPuertoDestino(Viaje viaje, TerminalPortuaria puertoDestino) {
		if (viaje.getpuertoDestino() == puertoDestino) {
			return viaje;
		}
		else {
			return null;
		}
	}
}
