package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.time.LocalDateTime;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;

public class FiltroFechaLlegada{

//	public FiltroFechaLlegada(String nombre) {
//		super(nombre);
//	}

	public Viaje filtrar(Viaje viaje, LocalDateTime fechaDestino) {
		if (viaje.getFechaDeLlegada() == fechaDestino) {
			return viaje;
		}
		else {
			return null;
		}
	}

//	@Override
//	public void Agregar(Componente componente) {
//		// TODO Auto-generated method stub
//		System.out.println("no se puede agregar la hoja");
//	}
//
//	@Override
//	public void Remover(Componente componente) {
//		// TODO Auto-generated method stub
//		System.out.println("no se puede quitar la hoja");
//	}
//
//	@Override
//	public void nivel(int nivel) {
//		// TODO Auto-generated method stub
//		System.out.println('-' + "" + nombre);
//	}

}
