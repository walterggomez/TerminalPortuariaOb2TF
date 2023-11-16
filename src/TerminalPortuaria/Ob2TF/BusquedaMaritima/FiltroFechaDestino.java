package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class FiltroFechaDestino extends Componente {

	
	public FiltroFechaDestino(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

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
		System.out.println("no se puede agregar la hoja");
	}

	@Override
	public void Remover(Componente componente) {
		// TODO Auto-generated method stub
		System.out.println("no se puede quitar la hoja");
	}

	@Override
	public void nivel(int nivel) {
		// TODO Auto-generated method stub
		System.out.println('-' + "" + nombre);
	}

	@Override
	public List<Viaje> filtrar(Viaje viaje, TerminalPortuaria puertoDestino) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
