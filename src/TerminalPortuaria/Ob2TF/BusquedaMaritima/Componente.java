package TerminalPortuaria.Ob2TF.BusquedaMaritima;


import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;

public interface Componente {

	
	
    abstract public void Agregar(Componente componente);
    abstract public void Remover(Componente componente);
    abstract public List<Viaje> filtrar(List<Viaje> listaDeViajes);

}
