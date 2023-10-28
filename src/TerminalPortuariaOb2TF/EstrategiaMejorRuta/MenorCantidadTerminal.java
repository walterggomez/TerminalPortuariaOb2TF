package TerminalPortuariaOb2TF.EstrategiaMejorRuta;

import java.util.List;

import TerminalPortuariaOb2TF.TerminalP.TerminalPortuaria;

public class MenorCantidadTerminal extends  MejorRuta {

	@Override
	public Circuito mejorCircuito(TerminalPortuaria puertoOrigen, TerminalPortuaria puertoDestino) {
		List<Circuito> circuitosConDestino = this.listaDeCircuitos(puertoOrigen,puertoDestino);
		Circuito cirConMenorEscala = circuitosConDestino.get(0);
		for (Circuito circ: circuitosConDestino) {
			   if (this.tieneMenosEscalas(cirConMenorEscala,circ)){
				   cirConMenorEscala = circ;
			   }
		}
		return cirConMenorEscala;

	}
	public boolean tieneMenosEscalas(Circuito primerCircuito, Circuito segundoCircuito) {
		return primerCircuito.getCantidadDeEscalas() < segundoCircuito.getCantidadDeEscalas();
	}




}
