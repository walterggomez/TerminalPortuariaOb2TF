package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.time.LocalDateTime;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public abstract class Componente {

	protected String nombre;
	
	public Componente (String nombre) {
		this.nombre = nombre;
	}
	
    abstract public void Agregar(Componente componente);
    abstract public void Remover(Componente componente);
    abstract public void nivel(int nivel);
    abstract public List<Viaje> filtrar(Viaje viaje, TerminalPortuaria puertoDestino);

}
