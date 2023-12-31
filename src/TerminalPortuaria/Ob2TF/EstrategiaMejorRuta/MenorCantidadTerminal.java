package TerminalPortuaria.Ob2TF.EstrategiaMejorRuta;

import java.util.List;

import TerminalPortuaria.Ob2TF.Circuito.Circuito;

import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class MenorCantidadTerminal extends  MejorRuta{

    @Override
    public Circuito mejorCircuito(TerminalPortuaria puertoOrigen, TerminalPortuaria puertoDestino) {
        List<Circuito> circuitosConDestino = this.listaDeCircuitos(puertoOrigen,puertoDestino);
        Circuito cirConMenorEscala = circuitosConDestino.get(0);
     for (Circuito circ: circuitosConDestino) {
      if (!this.tieneMenosEscalas(cirConMenorEscala.construirCircuitoDesdeHasta(puertoOrigen, puertoDestino),
              circ.construirCircuitoDesdeHasta(puertoOrigen, puertoDestino)))
     {
          cirConMenorEscala = circ;
      }
    }
    return cirConMenorEscala;


    }
    public boolean tieneMenosEscalas(Circuito primerCircuito, Circuito segundoCircuito) {
        return primerCircuito.cantidadDeEscalas() < segundoCircuito.cantidadDeEscalas();
    }


}
