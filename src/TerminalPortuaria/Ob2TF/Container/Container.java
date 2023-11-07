package TerminalPortuaria.Ob2TF.Container;

public abstract class Container {
	
	private int ancho;
	private int largo;
	private int altura;
	
	public Container(int ancho, int largo, int altura) {
		super();
		this.ancho = ancho;
		this.largo = largo;
		this.altura = altura;
	}

	public abstract int pesoTotal();
	
	

}
