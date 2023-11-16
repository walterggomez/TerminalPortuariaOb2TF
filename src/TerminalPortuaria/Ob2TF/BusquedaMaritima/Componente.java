package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import java.time.LocalDateTime;
import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public interface Componente {

	
	
    abstract public void Agregar(Componente componente);
    abstract public void Remover(Componente componente);
    abstract public List<Viaje> filtrar(Viaje viaje, TerminalPortuaria puertoDestino);

}
