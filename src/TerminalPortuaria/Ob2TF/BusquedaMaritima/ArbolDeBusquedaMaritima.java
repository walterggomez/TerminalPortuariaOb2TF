package TerminalPortuaria.Ob2TF.BusquedaMaritima;

import TerminalPortuaria.Ob2TF.Circuito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import TerminalPortuaria.Ob2TF.TerminalP.*;

public class ArbolDeBusquedaMaritima {
			//ESTRUCTURA BASICA PARA CREACION DE ARBOL
			//PARA USAR CON UN PATRON DE COMPOSITE
			//NOMBRE DEL ARBOL
			protected String nombre;
			//LISTA QUE CONTIENE OTROS ARBOLES DE BUSQUEDA
			protected List<ArbolDeBusquedaMaritima> arbolDeBusqueda;
			//TERMINAL SOBRE LA QUE SE REALIZAN LAS CONSULTAS
			protected TerminalPortuaria puertoGestionado;
			
			//CONSULTAS BASICAS DE BUSQUEDA
			
			//Devuelve una lista de los viajes que tienen por puerto destino al parametro puertoDestino
			public List<Viaje> viajesConMismoPuertoDestino(TerminalPortuaria puertoDestino) {
				return this.puertoGestionado.getMisViajes().stream().filter(t -> t.getpuertoDestino() == puertoDestino).toList();
			}
			
			//Devuelve una lista de los viajes que tienen una fecha de llegada igual al parametros fechaLlegada
			public List<Viaje> viajesConFechaDeLlegada(LocalDate fechaLlegada) {
				return this.puertoGestionado.getMisViajes().stream().filter(t -> t.getFechaDeLlegada() == fechaLlegada).toList();
			}
			
			//Devuelve una lista de los viajes que tienen una fecha de salida igual al parametro fechaSalida
			public List<Viaje> viajesConFechaDeSalida(LocalDate fechaSalida) {
				return this.puertoGestionado.getMisViajes().stream().filter(t -> t.getFechaDeSalida() == fechaSalida).toList();
			}
			
			//CONSTRUCTOR PARA PUERTO (SOBRE EL QUE SE REALIZA LA CONSULTA)
			public ArbolDeBusquedaMaritima(TerminalPortuaria terminalPortuaria) {
				this.puertoGestionado = terminalPortuaria;
				this.arbolDeBusqueda = null;
			}
			
			//CONSTRUCTOR DE ARBOLE SOBRE EL QUE SE REALIZA LA RECURSION
			public ArbolDeBusquedaMaritima(String nombre) {
				this.nombre = nombre;
				this.arbolDeBusqueda = new ArrayList<>();
			}
			
			//EL CODIGO A CONTINUACION ES A FIN DE PROBAR Y QUE FUNCIONE CORRECTAMENTE
			//LUEGO SE DEBE REALIZAR UN REFACTOR
			
			//SE EVALUA SI EL ELEMENTO ES COMPUESTO
			public boolean isComposite() {
				return arbolDeBusqueda != null;
			}
			
			
			public void agregar( ArbolDeBusquedaMaritima arbolDeBusqueda) {
				assert arbolDeBusqueda != null;
				if ( !this.isComposite()) {
					throw new UnsupportedOperationException("Operacion no valida");
				}
				else {
					this.arbolDeBusqueda.add(arbolDeBusqueda);
				}
			}
			
			
			public void remove (ArbolDeBusquedaMaritima arbolDeBusqueda) {
				assert arbolDeBusqueda != null;
				if (this.isComposite()) {
					this.arbolDeBusqueda.remove(arbolDeBusqueda);
				}
			}
			
			
			public int numeroDeArbolDeBusquedas() {
				if (this.isComposite()) {
					return this.arbolDeBusqueda.size();
				}
				else {
					return 1;
				}
			}
			
			
			public boolean esPuertoSalida(TerminalPortuaria puertoSalida) {
				if (this.isComposite()) {
					boolean resultado = false;
					for (ArbolDeBusquedaMaritima node : this.arbolDeBusqueda) {
						resultado = node.esIgualPuerto(puertoSalida);
					}
					return resultado;
				}
				else {
					return this.esIgualPuerto(puertoSalida);
				}
			}


}
