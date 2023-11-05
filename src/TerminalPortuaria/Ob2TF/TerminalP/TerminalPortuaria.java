package TerminalPortuaria.Ob2TF.TerminalP;
import java.awt.Point;
import java.util.List;

import TerminalPortuaria.Ob2TF.Naviera.Naviera;

public class TerminalPortuaria
{
	private Point  ubicacion;
	private List<Naviera> misNavieras;
	
	
	public TerminalPortuaria(Point ubicacion)
	{
		super();
		this.ubicacion = ubicacion;
	}

	public Point getUbicacion()
	{
		return ubicacion;
	}


	public List<Naviera> getMisNavieras()
	{
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
