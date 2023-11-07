package TerminalPortuaria.Ob2TF.Container;

public class Tanque extends Container {

	public Tanque(int ancho, int largo, int altura) {
		super(ancho, largo, altura);
	}

	@Override
	public int pesoTotal() {
		return 0;
	}

}
