package py.edu.facitec.proyecto_ventas.controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import py.edu.facitec.proyecto_ventas.modelo.dao.ClienteDAO;
import py.edu.facitec.proyecto_ventas.modelo.entidades.Categoria;
import py.edu.facitec.proyecto_ventas.modelo.entidades.Cliente;
import py.edu.facitec.proyecto_ventas.util.DataUtil;
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
		this.vCliente.getMiToolbar().setAcciones(this);

		estadoInicial(true);
		dao = new ClienteDAO();
		mtCliente = new ModeloTablaCliente();
		this.vCliente.getTable().setModel(mtCliente);

		recuperarTodo();
		setUpEvents();
	}

	private void setUpEvents() {
		vCliente.getTable().addMouseListener(this);
	}

	private void estadoInicial(boolean esInicial) {
		vCliente.gettNombre().setEditable(!esInicial);
		vCliente.gettApellido().setEditable(!esInicial);
		vCliente.gettDocumento().setEditable(!esInicial);
		vCliente.gettTelefono().setEditable(!esInicial);
		vCliente.gettEmail().setEditable(!esInicial);
		vCliente.gettFechaRegistro().setEditable(false);
		vCliente.getMiToolbar().estadoInicial(esInicial);
	}

	@Override
	public void cancelar() {
		estadoInicial(true);
		accion = "CANCELAR";

	}

	@Override
	public void eliminar() {
		estadoInicial(false);
		accion = "ELIMINAR";
		int posicion = vCliente.getTable().getSelectedRow();
		if (posicion < 0) {
			JOptionPane.showMessageDialog(vCliente, "Seleccione un registro");
			return;
		}
		int resp = JOptionPane.showConfirmDialog(vCliente, "Deseas eliminar el cliente " + cliente.getNombre() + "?",
				"ATENCI�N", JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			try {
				dao.eliminar(cliente);
				dao.commit();
				recuperarTodo();
			} catch (Exception e) {
				dao.rollback();
				e.printStackTrace();
			}
		}

	}

	@Override
	public void guardar() {
		if (accion.equals("NUEVO")) {
			cliente = new Cliente();
		}

		estadoInicial(false);
		cliente.setNombre(vCliente.gettNombre().getText());
		cliente.setApellido(vCliente.gettApellido().getText());
		cliente.setDocumento(vCliente.gettDocumento().getText());
		cliente.setEmail(vCliente.gettEmail().getText());
		cliente.setTelefono(vCliente.gettTelefono().getText());
		cliente.setFechaRegistro(Date.from(Instant.now()));

		try {
			cliente.setFechaRegistro(DataUtil.stringToDate(vCliente.gettFechaRegistro().getText()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			dao.guardar(cliente);
			dao.commit();

			estadoInicial(true);
			vaciarCampos();
			recuperarTodo();
			this.vCliente.getTable().setModel(mtCliente);
		} catch (Exception e) {
			dao.rollback();
			e.printStackTrace();
		}
		accion = "GUARDAR";
	}

	@Override
	public void modificar() {
		estadoInicial(false);
		accion = "MODIFICAR";

	}

	@Override
	public void nuevo() {
		estadoInicial(false);
		accion = "NUEVO";

	}

	@Override
	public void salir() {
		vCliente.dispose();

	}

	private void cargarFormulario(int posicion) {
		if (posicion < 0)
			return;
		cliente = lista.get(posicion);

		vCliente.gettNombre().setText(cliente.getNombre());
		vCliente.gettApellido().setText(cliente.getApellido());
		vCliente.gettDocumento().setText(cliente.getDocumento());
		vCliente.gettTelefono().setText(cliente.getTelefono());
		vCliente.gettEmail().setText(cliente.getEmail());
		vCliente.gettNombre().setText(cliente.getNombre());
		vCliente.gettNombre().setText(cliente.getNombre());

	}

	private void recuperarTodo() {
		// recupera los datos de la base para guardar en la variable lista y
		// setea en la tabla los datos
		lista = dao.recuperarTodo();
		mtCliente.setLista(lista);

	}

	private void vaciarCampos() {
		vCliente.gettNombre().setText("");
		vCliente.gettApellido().setText("");
		vCliente.gettDocumento().setText("");
		vCliente.gettTelefono().setText("");
		vCliente.gettEmail().setText("");
		vCliente.gettFechaRegistro().setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == vCliente.getTable()) {
			cargarFormulario(vCliente.getTable().getSelectedRow());
		}

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
}
