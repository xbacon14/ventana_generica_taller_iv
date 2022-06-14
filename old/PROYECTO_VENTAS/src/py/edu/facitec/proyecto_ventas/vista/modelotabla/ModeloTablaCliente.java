package py.edu.facitec.proyecto_ventas.vista.modelotabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import py.edu.facitec.proyecto_ventas.modelo.entidades.Cliente;

public class ModeloTablaCliente extends AbstractTableModel {

	private String[] columnas = { "ID", "NOMBRE", "APELLIDO", "DOCUMENTO", "TELEFONO", "EMAIL", "FECHA DE REGISTRO",
			"ESTADO" };
	private List<Cliente> lista = new ArrayList<Cliente>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 5580260137703896704L;

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public String getColumnName(int i) {
		return columnas[i];
	}

	@Override
	public Object getValueAt(int r, int c) {
		switch (c) {
		case 0:
			return lista.get(r).getId();
		case 1:
			return lista.get(r).getNombre();
		case 2:
			return lista.get(r).getApellido();
		case 3:
			return lista.get(r).getDocumento();
		case 4:
			return lista.get(r).getTelefono();
		case 5:
			return lista.get(r).getEmail();
		case 6:
			return lista.get(r).getFechaRegistro();
		case 7:
			return lista.get(r).getActivo();

		}
		return null;
	}

}
