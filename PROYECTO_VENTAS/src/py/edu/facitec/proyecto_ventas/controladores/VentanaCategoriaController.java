package py.edu.facitec.proyecto_ventas.controladores;

import py.edu.facitec.proyecto_ventas.vista.abms.VentanaCategoria;
import py.edu.facitec.reutilizacion.interfaces.AccionesABM;

public class VentanaCategoriaController implements AccionesABM{
	
	private VentanaCategoria vCategoria;

	public VentanaCategoriaController(VentanaCategoria vCategoria) {
		this.vCategoria = vCategoria;
		this.vCategoria.getMiToolbar().setAcciones(this);
	}

	@Override
	public void cancelar() {
		System.out.println("Cancelar categoria");
	}

	@Override
	public void eliminar() {
		System.out.println("Eliminar categoria");
	}

	@Override
	public void guardar() {
		System.out.println("Guardar categoria");
	}

	@Override
	public void modificar() {
		System.out.println("Modificar categoria");
	}

	@Override
	public void nuevo() {
		System.out.println("Nueva categoria");
	}

}
