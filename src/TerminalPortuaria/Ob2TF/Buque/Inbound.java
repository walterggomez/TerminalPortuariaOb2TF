package TerminalPortuaria.Ob2TF.Buque;

public class Inbound implements EstadoBuque {

	@Override
	public void actualizarEstado(Buque buque) 
	{
		if (this.distanciaATerminal(buque) == 0) {
			buque.setestadoBuque(new Arrived());
		}
	}
	
	public double distanciaATerminal(Buque buque) {
		//Implementacion de distancia buque a terminal
		return 100;
	}

	@Override
	public boolean estoyEnEstado(String string) {
		if (string == "Inbound") {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void evaluar(Buque buque) {
		// TODO Auto-generated method stub
		
	}



}
