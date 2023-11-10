package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.time.LocalDate;
import java.time.LocalDateTime;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;

public class FiltroFechaDestino implements Componente {

	
	public Viaje esViajeConFechaDestino(Viaje viaje, LocalDateTime fechaDestino) {
		if (viaje.getFechaDeLlegada() == fechaDestino) {
			return viaje;
		}
		else {
			return null;
		}
	}
	
}
