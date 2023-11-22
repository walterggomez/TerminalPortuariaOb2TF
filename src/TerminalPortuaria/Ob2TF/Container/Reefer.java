package TerminalPortuaria.Ob2TF.Container;

public class Reefer extends Container
{

	double consumoKwHora = 50;
	

	public Reefer(int ancho, int largo, int altura, int peso)
	{
		super(ancho, largo, altura, peso);
	}


	public double getConsumo() 
	{
		return consumoKwHora;
	}
	
	public void setConsumoKwHora(double consumoKwHora)
	{
		this.consumoKwHora = consumoKwHora;
	}

}
