package TerminalPortuaria.Ob2TF.EstrategiaMejorRuta;

import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

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
		return primerCircuito.costoTotalDelCircuito() < segundoCircuito.costoTotalDelCircuito();
	}


	
 



}
