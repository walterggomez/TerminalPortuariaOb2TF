package TerminalPortuaria.Ob2TF.Buque;

public class Arrived implements EstadoBuque {

	//Comentario para pushear
	@Override
	public void actualizarEstado(Buque buque) 
	{
		buque.setestadoBuque(new Working());
	}
	

	@Override
	public boolean estoyEnEstado(String string) {
		if (string == "Arrived") {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public double distanciaATerminal(Buque buque) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void evaluar(Buque buque) {
	}




}
