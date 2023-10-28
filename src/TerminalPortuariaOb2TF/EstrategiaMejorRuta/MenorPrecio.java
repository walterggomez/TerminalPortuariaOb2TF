package TerminalPortuariaOb2TF.EstrategiaMejorRuta;

import java.util.List;

import TerminalPortuariaOb2TF.TerminalP.TerminalPortuaria;

public class MenorPrecio extends MejorRuta{

	@Override
	public Circuito mejorCircuito(TerminalPortuaria puertoOrigen, TerminalPortuaria puertoDestino) {
		List<Circuito> circuitosConDestino = this.listaDeCircuitos(puertoOrigen,puertoDestino);
		Circuito cirMenorPrecio = circuitosConDestino.get(0);
		for (Circuito circ: circuitosConDestino) {
			   if (this.tieneMenorPrecio(cirMenorPrecio,circ)){
				   cirMenorPrecio = circ;
			   }
		}
		return cirMenorPrecio;
	}

	public boolean tieneMenorPrecio(Circuito primerCircuito, Circuito segundoCircuito) {
		return primerCircuito.getPrecio() < segundoCircuito.getPrecio();
	}


	




}
