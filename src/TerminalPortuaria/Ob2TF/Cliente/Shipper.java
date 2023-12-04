package TerminalPortuaria.Ob2TF.Cliente;

public class Shipper extends Cliente {

	public Shipper(String nombre, int codigoCliente) {
		super(nombre, codigoCliente);
	}

	@Override
	public boolean soyConsignee() {
		return false;
	}
	
	@Override
	public boolean soyShipper() {
		return true;
	}



	
	
}
