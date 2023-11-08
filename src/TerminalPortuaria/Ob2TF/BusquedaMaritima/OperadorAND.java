
package TerminalPortuaria.Ob2TF.BusquedaMaritima;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.*;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class OperadorAND {

		protected List<Viaje> todosLosViajes;


		public List<Viaje> viajesConMismoPuertoDestino(TerminalPortuaria puertoDestino) {
			return this.todosLosViajes.stream().filter(t -> t.getpuertoDestino() == puertoDestino).toList();
		}
		
		public List<Viaje> viajesConFechaDeLlegada(LocalDateTime fechaLlegada) {
			return this.todosLosViajes.stream().filter(t -> t.getFechaDeLlegada() == fechaLlegada).toList();
		}
		
		//Devuelve una lista de los viajes que tienen una fecha de salida igual al parametro fechaSalida
		public List<Viaje> viajesConFechaDeSalida(LocalDateTime fechaSalida) {
			return this.todosLosViajes.stream().filter(t -> t.getFechaDeSalida() == fechaSalida).toList();
		}
	    
	    public OperadorAND(List<Viaje> viajes) {
	    	this.todosLosViajes = viajes;
	    }
		
		
	    

		public List<Viaje> match (TerminalPortuaria puertoDestino, LocalDateTime fechaLlegada) {
			List<Viaje> viajesPorPuerto = this.viajesConMismoPuertoDestino(puertoDestino);
		    List<Viaje> viajesPorFecha = this.viajesConFechaDeLlegada(fechaLlegada);
		    List<Viaje> viajesUnidos = new ArrayList<>();
		    viajesUnidos.addAll(viajesPorPuerto);
		    viajesUnidos.addAll(viajesPorFecha);
			
	        return viajesUnidos;
	    }


	
}
