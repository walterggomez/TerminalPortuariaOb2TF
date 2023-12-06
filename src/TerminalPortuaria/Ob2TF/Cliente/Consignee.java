package TerminalPortuaria.Ob2TF.Cliente;

public class Consignee extends Cliente{
	
	
	public Consignee(String nombre, int codigoCliente) {
		super(nombre, codigoCliente);
	}
	

	@Override
	public boolean soyConsignee() {
		return true;
	}
	
	@Override
	public boolean soyShipper() {
		return false;
	}
	

}
