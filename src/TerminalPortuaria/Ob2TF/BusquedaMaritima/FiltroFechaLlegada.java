package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.time.LocalDateTime;

import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;

public class FiltroFechaLlegada implements Componente{
	
	private LocalDateTime fechaLlegada;

	
	public FiltroFechaLlegada(LocalDateTime fechaLlegada) {
		super();
		this.fechaLlegada = fechaLlegada;
	}
	
	//FILTRA VIAJES CON FECHA DADO POR fechaLlegada
	@Override
	public List<Viaje> filtrar(List<Viaje> listaDeViajes) {
		return listaDeViajes.stream().filter(v -> v.getFechaDeLlegada() == this.fechaLlegada).toList();
	}
	
	

	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}

	@Override
	public void Agregar(Componente componente) {
		throw new UnsupportedOperationException("No Valido");
	}

	@Override
	public void Remover(Componente componente) {
	}


}
