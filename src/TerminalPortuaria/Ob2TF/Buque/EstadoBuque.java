package TerminalPortuaria.Ob2TF.Buque;

public interface EstadoBuque {
	void actualizarEstado(Buque buque);

	boolean estoyEnEstado(String string);

}
