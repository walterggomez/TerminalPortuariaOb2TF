package TerminalPortuaria.Ob2TF.Circuito;

import java.util.ArrayList;
import java.util.List;

import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Circuito {

	private List<Tramo> listaDeTramo = new ArrayList<Tramo>();

	public List<Tramo> getListaDeTramo() {
		return listaDeTramo;
	}
	
	public void setListaDeTramo(List<Tramo> listaDeTramo) {
		this.listaDeTramo = listaDeTramo;
	}
	
	public TerminalPortuaria puertoDestinoCircuito() {
		return listaDeTramo.get(listaDeTramo.size() -1 ).getPuertoDestino();
	}
	
	public TerminalPortuaria puertoOrigenCircuito() {
		return listaDeTramo.get(0).getPuertoOrigen();
	}

	
	public void agregarNuevoTramo(Tramo tramo) throws Exception {
	Tramo ultimoTramo = listaDeTramo.get(listaDeTramo.size() -1 );
	if (ultimoTramo.getPuertoDestino() == tramo.getPuertoOrigen()) {
		listaDeTramo.add(tramo);
	}
	else {
		throw new Exception("Este tramo no es valido");
	}
	//Faltaria contemplar un try/catch para el caso de que sea una lista vacia
}

	
	public double costoTotalDelCircuito() {
		double costoTotal = 0;
		for (Tramo tramo:this.listaDeTramo) {
			costoTotal = costoTotal + tramo.getCostoDetramo();
		}
		return costoTotal;
	}
	
	public boolean contieneA(TerminalPortuaria puertoDestino) {
		return this.listaDeTramo.stream().anyMatch(t -> t.getPuertoDestino() == puertoDestino );
	}

}
