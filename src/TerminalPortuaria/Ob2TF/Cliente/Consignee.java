package TerminalPortuaria.Ob2TF.Cliente;

public class Consignee extends Cliente{
	
	
	public Consignee(String nombre, int codigoCliente) {
		super(nombre, codigoCliente);
	}

	@Override
	public boolean soy(String string) {
		if (string == "Consignee") {
			return true;
		}
		else {
			return false;
		}
	}

}
