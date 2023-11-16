package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.util.ArrayList;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class FiltroPuertoDestino extends Componente {

	public FiltroPuertoDestino(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

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
		// TODO Auto-generated method stub
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
}
