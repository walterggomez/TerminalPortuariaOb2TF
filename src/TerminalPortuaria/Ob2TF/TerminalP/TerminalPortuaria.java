package TerminalPortuaria.Ob2TF.TerminalP;

import java.awt.Point;
import java.util.List;

import TerminalPortuaria.Ob2TF.Naviera.Naviera;

public class TerminalPortuaria
{
	
	private List<Naviera> misNavieras;
	
	Point  ubicacion = new Point(0, 0);
	
	
	public Point getUbicacion()
	{
		return ubicacion;
	}


	public List<Naviera> getMisNavieras() {
		return misNavieras;
	}
	
	
	
	/*
	 private EstrategiaMejorRuta estrategiaSeleccionada;
	 
	 
	 
	 
	 private void setMejorCircuito( EstrategiaMejorRuta estrategia )
	 {
	 	this.mejorCircuito = estrategia;
	 }
	 
	 
	 public Circuito getMejorCircuito(TerminalGestionada terminalDestino)
	 {
	 	return this.estrategiaSeleccionada.mejorCircuito(this, terminalDestino);
	 }
	 
	 
	 */
	
	
}
