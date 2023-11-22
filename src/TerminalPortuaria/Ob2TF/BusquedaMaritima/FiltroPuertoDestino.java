package TerminalPortuaria.Ob2TF.BusquedaMaritima;


import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class FiltroPuertoDestino implements Componente {

	private TerminalPortuaria puertoDestino;
	
	public FiltroPuertoDestino(TerminalPortuaria puertoDestino) {
		super();
		this.puertoDestino = puertoDestino;
	}
	
	
	

	public TerminalPortuaria getPuertoDestino() {
		return puertoDestino;
	}




	@Override
	public List<Viaje> filtrar(List<Viaje> listaDeViajes) {
		return listaDeViajes.stream().filter(v -> v.getpuertoDestino() == this.puertoDestino).toList();
	}
	
	

	@Override
	public void Agregar(Componente componente) {
		throw new UnsupportedOperationException("No Valido");
	}

	@Override
	public void Remover(Componente componente) {
	}


}
