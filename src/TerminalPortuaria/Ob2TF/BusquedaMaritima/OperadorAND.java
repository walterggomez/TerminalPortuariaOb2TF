
package TerminalPortuaria.Ob2TF.BusquedaMaritima;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.*;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class OperadorAND implements Componente {

		String nombre;
		List<Componente> hijos = new ArrayList<Componente>();
		
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
		public List<Viaje> filtrar(Viaje viaje, TerminalPortuaria puertoDestino) {
			List<Viaje> viajesFiltrados = new ArrayList<>();
			for (Componente hijo : hijos) {
				viajesFiltrados.addAll(hijo.filtrar(viaje, puertoDestino));
			}
			return viajesFiltrados;
		}

}
