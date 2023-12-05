package TerminalPortuaria.Ob2TF.Buque;

public class Outbound implements EstadoBuque {


	@Override
	public void actualizarEstado(Buque buque)
	{
			buque.setestadoBuque( new Inbound() );
			buque.getViajeActual().getpuertoDestino().darAvisoConsignees( buque.getViajeActual() );
	}


	public double distanciaATerminal(Buque buque) 
	{
		return 100;
	}
	
	public void evaluar(Buque buque) 
	{
		if (this.distanciaATerminal(buque) < 50) 
		{
			this.actualizarEstado(buque);
		}
	}
	
	
	

	@Override
	public boolean estoyEnEstado(String string) 
	{
		if (string == "Outbound") 
		{
			return true;
		} else 
		{
			return false;
		}
	}
}
