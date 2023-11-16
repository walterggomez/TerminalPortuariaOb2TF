package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.util.ArrayList;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class FiltroPuertoDestino implements Componente {



	@Override
	public List<Viaje> filtrar(Viaje viaje, TerminalPortuaria puertoDestino) {
		List<Viaje> viajesFiltrados = new ArrayList<>();
		if (viaje.getpuertoDestino() == puertoDestino) {
			viajesFiltrados.add(viaje);
		}
		return viajesFiltrados;
	}

	@Override
	public void Agregar(Componente componente) {
		throw new UnsupportedOperationException("No Valido");
	}

	@Override
	public void Remover(Componente componente) {
	}


}
