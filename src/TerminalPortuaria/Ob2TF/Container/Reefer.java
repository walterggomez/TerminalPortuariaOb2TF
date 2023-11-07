package TerminalPortuaria.Ob2TF.Container;

public class Reefer extends Container{

	double consumoKwHora;
	
	public Reefer(int ancho, int largo, int altura, double kwhora) {
		super(ancho, largo, altura);
		this.consumoKwHora = kwhora;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getConsumo() {
		return consumoKwHora;
	}
}
