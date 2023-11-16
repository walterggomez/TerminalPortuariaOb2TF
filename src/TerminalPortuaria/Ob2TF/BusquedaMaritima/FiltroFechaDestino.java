package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class FiltroFechaDestino implements Componente {
	
	

//	@Override
//	public Viaje filtrar(Viaje viaje, LocalDateTime fechaDestino) {
//		if (viaje.getFechaDeLlegada() == fechaDestino) {
//			return viaje;
//		}
//		else {
//			return null;
//		}
//	}

	@Override
	public void Agregar(Componente componente) {
		throw new UnsupportedOperationException("No Valido");
	}

	@Override
	public void Remover(Componente componente) {
	}


	@Override
	public List<Viaje> filtrar(Viaje viaje, TerminalPortuaria puertoDestino) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
