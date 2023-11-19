package TerminalPortuaria.Ob2TF.Container;

public class Reefer extends Container{

	double consumoKwHora;
	
	public Reefer(int ancho, int largo, int altura, int peso, double consumoKwHora) {
		super(ancho, largo, altura, peso);
		this.consumoKwHora = consumoKwHora;
	}


	@Override
	public boolean necesitaRefrigeracion() {
		return true;
	}
	
	public double getConsumo() {
		return consumoKwHora;
	}
}
