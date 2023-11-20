package TerminalPortuaria.Ob2TF.BusquedaMaritima;


import java.time.LocalDateTime;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;

public class FiltroFechaDestino implements Componente {
	
	private LocalDateTime fechaDestino;
	
	
	//FILTRA VIAJES CON DESTINO DADO POR fechaDestino
	@Override
	public List<Viaje> filtrar(List<Viaje> listaDeViajes) {
		return listaDeViajes.stream().filter(v -> v.getFechaDeLlegada() == this.fechaDestino).toList();
	}



	@Override
	public void Agregar(Componente componente) {
		throw new UnsupportedOperationException("No Valido");
	}

	@Override
	public void Remover(Componente componente) {
	}

	
}
