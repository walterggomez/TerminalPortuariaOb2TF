package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.util.ArrayList;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class OperadorOR implements Componente {

	String nombre;
	List<Componente> hijo = new ArrayList<Componente>();
	
	public OperadorOR(String nombre) {
	this.nombre = nombre;
	// TODO Auto-generated constructor stub
}

	@Override
	public void Agregar(Componente componente) {
		// TODO Auto-generated method stub
		hijo.add(componente);
	}

	@Override
	public void Remover(Componente componente) {
		// TODO Auto-generated method stub
		hijo.remove(componente);
	}


	@Override
	public List<Viaje> filtrar(Viaje viaje, TerminalPortuaria puertoDestino) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
