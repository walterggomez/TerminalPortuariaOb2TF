package TerminalPortuaria.Ob2TF.TerminalP;

public interface CostoServicios 

{
	public double setCostoServicioPesaje(double nuevoCosto);
	
	public double setCostoKwConsumido(double nuevoCosto);
	
	public double setCostoAlmacenamientoExcedente(double nuevoCosto);
	
	public double getCostoAlmacenamientoExcedente();
	
	public double getCostoKwConsumido();
	
	public double getCostoServicioPesaje();
}
