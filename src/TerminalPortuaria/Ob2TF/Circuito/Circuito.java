package TerminalPortuaria.Ob2TF.Circuito;

import java.util.ArrayList;
import java.util.List;

public class Circuito {

	private List<Tramo> listaDeTramo = new ArrayList<Tramo>();

	public List<Tramo> getListaDeTramo() {
		return listaDeTramo;
	}

	public void setListaDeTramo(List<Tramo> listaDeTramo) {
		this.listaDeTramo = listaDeTramo;
	}
	
	public void validarTramo(Tramo tramo) {
		Tramo ultimoTramo = listaDeTramo.get(listaDeTramo.size() -1 );
		if (ultimoTramo.getPuertoDestino() == tramo.getPuertoOrigen()) {
			listaDeTramo.add(tramo);
		}
		else {
		}
	}
}
