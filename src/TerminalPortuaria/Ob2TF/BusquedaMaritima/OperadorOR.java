package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.util.ArrayList;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;

public class OperadorOR implements Componente {

	protected String nombre;
	protected List<Componente> hijos;
	
	public OperadorOR(String nombre) {
		this.nombre = nombre;
		this.hijos = new ArrayList<>();
		// TODO Auto-generated constructor stub
	    }

	@Override
	public void Agregar(Componente componente) {
		// TODO Auto-generated method stub
		hijos.add(componente);
	}

	@Override
	public void Remover(Componente componente) {
		// TODO Auto-generated method stub
		hijos.remove(componente);
	}


	@Override
	public List<Viaje> filtrar(List<Viaje> listaDeViajes) {
		List<Viaje> viajesFiltrados = new ArrayList<>();
		for (Componente componente : hijos) {
			viajesFiltrados.addAll(componente.filtrar(listaDeViajes));
		}
		return viajesFiltrados;
	}

	public List<Componente> getHijos() {
		return hijos;
	}
	
	
}
