package TerminalPortuaria.Ob2TF.EstrategiaMejorRuta;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public abstract class MejorRuta {

	public abstract Circuito mejorCircuito(TerminalPortuaria puertoOrigen, TerminalPortuaria puertoDestino);

	public List<Circuito> listaDeCircuitos(TerminalPortuaria puertoOrigen, TerminalPortuaria puertoDestino) {
		/* Le pido al puerto de origen su lista de naviera */
		List<Naviera> listaNavieras = this.navierasDelPuerto(puertoOrigen);
		/* Armo la lista de todos los circuitos maritimos */
		List<Circuito> todosLoscircuitos = this.todosLosCircuitosMaritimos(listaNavieras);
		/* Filtro los circuitos que contengan al puerto destino */
		List<Circuito> circuitosConDestino = todosLoscircuitos.stream().filter(cir -> cir.validarSiTerminalExisteEnCircuito(puertoDestino))
				.collect(Collectors.toList());
		return circuitosConDestino;
	}

	public List<Circuito> todosLosCircuitosMaritimos(List<Naviera> listaNavieras) {
		/*
		 * A cada naviera le tengo que pedir su lista de circuitos y armar una lista
		 * unica de circuitos
		 */
		List<Circuito> todosLosCircuitosT = new ArrayList<>();
		for (Naviera nav : listaNavieras) {
			todosLosCircuitosT.addAll(nav.getMisCircuitos());
		}
		return todosLosCircuitosT;
	}

	public List<Naviera> navierasDelPuerto(TerminalPortuaria puertoOrigen)
	{
		return puertoOrigen.getMisNavieras();
	}
	
	/* [naviera1,naviera2,naviera3,naviera4]*/
	
	/*[ [cir 1,cir 2, cir 3],[cir 4,cir 5],[cir 6,cir 7, cir 8],[cir 9,cir 10] ]*/
	
	/*[ cir 1,cir 2, cir 3,cir 4,cir 5,cir 6,cir 7, cir 8,cir 9,cir 10 ]*/
	
	/*validarSiTerminalExisteEnCircuito*/
	
	
}
