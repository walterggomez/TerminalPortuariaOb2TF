package TerminalPortuaria.Ob2TF.BusquedaMaritima;


import java.time.LocalDateTime;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;

public class FiltroFechaSalida implements Componente {
	
	private LocalDateTime fechaDeSalida;
	
	
	public FiltroFechaSalida(LocalDateTime fecha) {
		super();
		this.fechaDeSalida = fecha;
	}
	
	//FILTRA VIAJES CON DESTINO DADO POR fechaDestino
	@Override
	public List<Viaje> filtrar(List<Viaje> listaDeViajes) {
		return listaDeViajes.stream().filter(v -> v.getFechaDeSalida() == this.fechaDeSalida).toList();
	}



	public LocalDateTime getFechaDestino() {
		return fechaDeSalida;
	}

	@Override
	public void Agregar(Componente componente) {
		throw new UnsupportedOperationException("No Valido");
	}

	@Override
	public void Remover(Componente componente) {
	}

	
}
