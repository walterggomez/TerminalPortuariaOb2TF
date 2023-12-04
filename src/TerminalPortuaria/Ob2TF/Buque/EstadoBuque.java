package TerminalPortuaria.Ob2TF.Buque;

public interface EstadoBuque {
	void actualizarEstado(Buque buque);

	public boolean estoyEnEstado(String string);
	public double distanciaATerminal(Buque buque);

	void evaluar(Buque buque);
}
