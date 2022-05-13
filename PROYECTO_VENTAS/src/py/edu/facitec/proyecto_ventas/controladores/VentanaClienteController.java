package py.edu.facitec.proyecto_ventas.controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import py.edu.facitec.proyecto_ventas.modelo.dao.ClienteDAO;
import py.edu.facitec.proyecto_ventas.modelo.entidades.Cliente;
import py.edu.facitec.proyecto_ventas.vista.abms.VentanaCliente;
import py.edu.facitec.proyecto_ventas.vista.modelotabla.ModeloTablaCliente;
import py.edu.facitec.reutilizacion.interfaces.AccionesABM;

public class VentanaClienteController implements AccionesABM, MouseListener {
	private VentanaCliente vCliente;
	private Cliente cliente;
	private ClienteDAO dao;
	private ModeloTablaCliente mtCliente;
	private List<Cliente> lista;
	private String accion;

	public VentanaClienteController(VentanaCliente vCliente) {
		super();
		this.vCliente = vCliente;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void nuevo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void salir() {
		// TODO Auto-generated method stub

	}
}
