package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.time.LocalDateTime;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;

public class FiltroFechaLlegada implements Componente {

	public Viaje esViajeConFechaDestino(Viaje viaje, LocalDateTime fechaDestino) {
		if (viaje.getFechaDeLlegada() == fechaDestino) {
			return viaje;
		}
		else {
			return null;
		}
	}
}
