package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;

public class Pesado implements Servicios // Se intancia en todas las ordenes de exportación.
{
	private double costoPesaje = 50;

	public void setCostoPesaje(double costoPesaje) {
		this.costoPesaje = costoPesaje;
	}

	@Override
	public double costoServicio(Orden orden) {
		return this.costoPesaje;
	}

	public double getCostoPesaje() {
		return costoPesaje;
	}
	

}
