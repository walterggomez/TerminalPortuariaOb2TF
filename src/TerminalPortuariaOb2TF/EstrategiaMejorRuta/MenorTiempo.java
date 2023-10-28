package TerminalPortuariaOb2TF.EstrategiaMejorRuta;

import java.util.List;

import TerminalPortuariaOb2TF.TerminalP.TerminalPortuaria;

public class MenorTiempo extends  MejorRuta{

	public MenorTiempo() {
		
	}

	@Override
	public Circuito mejorCircuito(TerminalPortuaria puertoOrigen, TerminalPortuaria puertoDestino) {
		List<Circuito> circuitosConDestino = this.listaDeCircuitos(puertoOrigen,puertoDestino);
		Circuito cirMenorTiempo = circuitosConDestino.get(0);
		for (Circuito circ: circuitosConDestino) {
			   if (this.tieneMenorTiempo(cirMenorTiempo,circ)){
				   cirMenorTiempo = circ;
			   }
		}
		return cirMenorTiempo;
	}
	public boolean tieneMenorTiempo(Circuito primerCircuito, Circuito segundoCircuito) {
		return primerCircuito.getDuracion() < segundoCircuito.getDuracion();
	}

}
