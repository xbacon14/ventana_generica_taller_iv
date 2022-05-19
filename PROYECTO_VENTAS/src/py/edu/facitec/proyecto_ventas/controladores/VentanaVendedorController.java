package py.edu.facitec.proyecto_ventas.controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import py.edu.facitec.proyecto_ventas.modelo.dao.VendedorDAO;
import py.edu.facitec.proyecto_ventas.modelo.entidades.Vendedor;
import py.edu.facitec.proyecto_ventas.util.DataUtil;
import py.edu.facitec.proyecto_ventas.vista.abms.VentanaVendedor;
import py.edu.facitec.proyecto_ventas.vista.modelotabla.ModeloTablaVendedor;
import py.edu.facitec.reutilizacion.interfaces.AccionesABM;

public class VentanaVendedorController implements AccionesABM, MouseListener {

	private VentanaVendedor vVendedor;
	private Vendedor vendedor;
	private VendedorDAO dao;
	private ModeloTablaVendedor mtVendedor;
	private List<Vendedor> lista;
	private String accion;

	public VentanaVendedorController(VentanaVendedor vVendedor) {
		super();
		this.vVendedor = vVendedor;
		this.vVendedor.getMiToolbar().setAcciones(this);
		estadoInicial(true);
		dao = new VendedorDAO();
		mtVendedor = new ModeloTablaVendedor();
		this.vVendedor.getTable().setModel(mtVendedor);

		recuperarTodo();
		setUpEvents();

	}

	private void setUpEvents() {
		vVendedor.getTable().addMouseListener(this);
	}

	private void recuperarTodo() {
		lista = dao.recuperarTodo();
		mtVendedor.setLista(lista);
	}

	private void vaciarCampos() {
		vVendedor.gettNombre().setText("");
		vVendedor.gettApellido().setText("");
		vVendedor.gettDocumento().setText("");
		vVendedor.gettTelefono().setText("");
		vVendedor.gettEmail().setText("");
		vVendedor.gettFechaNac().setText("");
	}

	private void estadoInicial(boolean esInicial) {
		vVendedor.gettNombre().setEditable(!esInicial);
		vVendedor.gettApellido().setEditable(!esInicial);
		vVendedor.gettDocumento().setEditable(!esInicial);
		vVendedor.gettTelefono().setEditable(!esInicial);
		vVendedor.gettEmail().setEditable(!esInicial);
		vVendedor.gettFechaNac().setEditable(false);
		vVendedor.getMiToolbar().estadoInicial(esInicial);
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
		int posicion = vVendedor.getTable().getSelectedRow();
		if (posicion < 0) {
			JOptionPane.showMessageDialog(vVendedor, "Seleccione un registro");
			return;
		}
		int resp = JOptionPane.showConfirmDialog(vVendedor, "Deseas eliminar el vendedor " + vendedor.getNombre() + "?",
				"ATENCI�N", JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			try {
				dao.eliminar(vendedor);
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
			vendedor = new Vendedor();
		}

		estadoInicial(false);
		vendedor.setNombre(vVendedor.gettNombre().getText());
		vendedor.setApellido(vVendedor.gettApellido().getText());
		vendedor.setDocumento(vVendedor.gettDocumento().getText());
		vendedor.setEmail(vVendedor.gettEmail().getText());
		vendedor.setTelefono(vVendedor.gettTelefono().getText());
		vendedor.setFechaNacimiento(Date.from(Instant.now()));

		try {
			dao.guardar(vendedor);
			dao.commit();

			estadoInicial(true);
			vaciarCampos();
			recuperarTodo();
			this.vVendedor.getTable().setModel(mtVendedor);
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
		vVendedor.dispose();

	}

	private void cargarFormulario(int posicion) {
		if (posicion < 0)
			return;
		vendedor = lista.get(posicion);

		vVendedor.gettNombre().setText(vendedor.getNombre());
		vVendedor.gettApellido().setText(vendedor.getApellido());
		vVendedor.gettDocumento().setText(vendedor.getDocumento());
		vVendedor.gettTelefono().setText(vendedor.getTelefono());
		vVendedor.gettEmail().setText(vendedor.getEmail());
		vVendedor.gettNombre().setText(vendedor.getNombre());
		vVendedor.gettNombre().setText(vendedor.getNombre());

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == vVendedor.getTable()) {
			cargarFormulario(vVendedor.getTable().getSelectedRow());
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
