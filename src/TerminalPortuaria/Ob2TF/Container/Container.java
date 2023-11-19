package TerminalPortuaria.Ob2TF.Container;

public abstract class Container {
	
	private int ancho;
	private int largo;
	private int altura;
	private int peso;
	
	public Container(int ancho, int largo, int altura, int peso) {
		super();
		this.ancho = ancho;
		this.largo = largo;
		this.altura = altura;
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}

	public int volumen() {
		return this.ancho * this.largo * this.altura;
	}
	
	public boolean necesitaRefrigeracion() {
		return false;
	}
	
	public boolean isAptoLiquido() {
		return false;
	}
	
}
