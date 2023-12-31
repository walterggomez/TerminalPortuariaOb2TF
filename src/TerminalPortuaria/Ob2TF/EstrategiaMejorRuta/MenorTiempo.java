package TerminalPortuaria.Ob2TF.EstrategiaMejorRuta;

import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class MenorTiempo extends  MejorRuta{


	@Override
	public Circuito mejorCircuito(TerminalPortuaria puertoOrigen, TerminalPortuaria puertoDestino) {
		List<Circuito> circuitosConDestino = this.listaDeCircuitos(puertoOrigen,puertoDestino);
		Circuito cirMenorTiempo = circuitosConDestino.get(0);
		for (Circuito circ: circuitosConDestino) {
			   if (!this.tieneMenorTiempo(cirMenorTiempo,circ)){
				   cirMenorTiempo = circ;
			   }
		}
		return cirMenorTiempo;
	}
	public boolean tieneMenorTiempo(Circuito primerCircuito, Circuito segundoCircuito) {
		return primerCircuito.duracionCircuito() < segundoCircuito.duracionCircuito();
	}

}
