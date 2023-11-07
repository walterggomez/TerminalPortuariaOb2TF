package TerminalPortuaria.Ob2TF.Container;

public abstract class Container {
	
	private int ancho;
	private int largo;
	private int altura;
	private int peso;
	
	public Container(int ancho, int largo, int altura) {
		super();
		this.ancho = ancho;
		this.largo = largo;
		this.altura = altura;
	}
	
	public int getPeso() {
		return peso;
	}

	public int volumen() {
		return this.ancho * this.largo * this.altura;
	}
	
	public double getConsumo() {
		return 0;
	}
}
