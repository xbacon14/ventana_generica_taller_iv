package py.edu.facitec.proyecto_ventas.controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;

import py.edu.facitec.proyecto_ventas.modelo.dao.CategoriaDAO;
import py.edu.facitec.proyecto_ventas.modelo.entidades.Categoria;
import py.edu.facitec.proyecto_ventas.vista.abms.VentanaCategoria;
import py.edu.facitec.proyecto_ventas.vista.modelotabla.ModeloTablaCategoria;
import py.edu.facitec.reutilizacion.interfaces.AccionesABM;

public class VentanaCategoriaController implements AccionesABM, MouseListener {

	private VentanaCategoria vCategoria;
	private Categoria categoria;
	private CategoriaDAO dao;
	private ModeloTablaCategoria mtCategoria;
	private List<Categoria> lista;
	private String accion;

	public VentanaCategoriaController(VentanaCategoria vCategoria) {
		this.vCategoria = vCategoria;
		this.vCategoria.getMiToolbar().setAcciones(this);

		estadoInicial(true);
		dao = new CategoriaDAO();
		mtCategoria = new ModeloTablaCategoria();
		this.vCategoria.getTable().setModel(mtCategoria);

		recuperarTodo();
		setUpEvents();
	}

	private void setUpEvents() {
		vCategoria.getTable().addMouseListener(this);

	}

	private void estadoInicial(boolean esInicial) {
		vCategoria.gettDescripcion().setEditable(!esInicial);
		vCategoria.getMiToolbar().estadoInicial(esInicial);
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
		int posicion = vCategoria.getTable().getSelectedRow();
		if (posicion < 0) {
			JOptionPane.showMessageDialog(vCategoria, "Seleccione un registro");
			return;
		}
		int resp = JOptionPane.showConfirmDialog(vCategoria,
				"Deseas eliminar la categoria " + categoria.getDescripcion() + "?", "ATENCIÓN",
				JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			try {
				dao.eliminar(categoria);
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
			categoria = new Categoria();
		}

		estadoInicial(false);
		categoria.setDescripcion(vCategoria.gettDescripcion().getText());
		try {
			dao.guardar(categoria);
			dao.commit();

			estadoInicial(true);
			vaciarCampos();
			recuperarTodo();
			this.vCategoria.getTable().setModel(mtCategoria);
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
		vCategoria.dispose();
	}

	private void cargarFormulario(int posicion) {
		if (posicion < 0)
			return;
		categoria = lista.get(posicion);

		vCategoria.gettDescripcion().setText(categoria.getDescripcion());

	}

	private void recuperarTodo() {
		// recupera los datos de la base para guardar en la variable lista y
		// setea en la tabla los datos
		lista = dao.recuperarTodo();
		mtCategoria.setLista(lista);

	}

	private void vaciarCampos() {
		vCategoria.gettDescripcion().setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == vCategoria.getTable()) {
			cargarFormulario(vCategoria.getTable().getSelectedRow());
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
