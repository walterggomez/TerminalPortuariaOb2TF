package TerminalPortuaria.Ob2TF.EstrategiaMejorRuta;

import java.util.List;
import java.util.stream.Collectors;

import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public abstract class MejorRuta {
	
	public abstract Circuito mejorCircuito(TerminalPortuaria puertoOrigen,TerminalPortuaria puertoDestino);
	
	
	public List<Circuito> listaDeCircuitos(TerminalPortuaria puertoOrigen,TerminalPortuaria puertoDestino){
		/* Le pido al puertoOrigen a travez de sus navieras todos los circuitos */
		List<Circuito> listaCircuitos = puertoOrigen.getNavieras().getCircuitos();
		/* Filtro los circuitos que contengan al puerto destino*/
		List<Circuito> circuitosConDestino = listaCircuitos.stream().filter(cir->cir.contieneA(puertoDestino)).collect(Collectors.toList());
		return circuitosConDestino;
	}
	

	
	
	
	
	
	
}
