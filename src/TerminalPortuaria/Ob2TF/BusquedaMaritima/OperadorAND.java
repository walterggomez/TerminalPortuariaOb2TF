
package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.util.ArrayList;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.*;

public class OperadorAND implements Componente {

		String nombre;
		List<Componente> hijos;
		
		public OperadorAND(String nombre) {
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
				viajesFiltrados.retainAll(componente.filtrar(listaDeViajes));
			}
			return viajesFiltrados;
		}
		
		public List<Componente> getHijos() {
			return hijos;
		}
		

}
