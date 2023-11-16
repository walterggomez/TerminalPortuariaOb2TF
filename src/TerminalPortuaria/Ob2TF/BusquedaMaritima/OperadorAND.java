
package TerminalPortuaria.Ob2TF.BusquedaMaritima;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.*;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class OperadorAND extends Componente {


		List<Componente> hijos = new ArrayList<Componente>();
		List<Viaje> viajesFiltrados = new ArrayList<>();
		
		public OperadorAND(String nombre) {
		super(nombre);
		this.viajesFiltrados = new ArrayList<>();
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
		public void nivel(int nivel) {
			// TODO Auto-generated method stub
			for (int i = 0; i < hijos.size(); i++)
	            hijos.get(i).nivel(nivel + 1);
		}

		@Override
		public List<Viaje> filtrar(Viaje viaje, TerminalPortuaria puertoDestino) {
			List<Viaje> viajesFiltrados = new ArrayList<>();
			for (Componente hijo : hijos) {
				viajesFiltrados.addAll(hijo.filtrar(viaje, puertoDestino));
			}
			return viajesFiltrados;
		}

}
