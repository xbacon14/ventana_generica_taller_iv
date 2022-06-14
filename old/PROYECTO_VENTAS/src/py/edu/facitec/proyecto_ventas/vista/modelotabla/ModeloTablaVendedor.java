package py.edu.facitec.proyecto_ventas.vista.modelotabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import py.edu.facitec.proyecto_ventas.modelo.entidades.Vendedor;

public class ModeloTablaVendedor extends AbstractTableModel {
	private static final long serialVersionUID = 1074747329752723443L;
	private String[] columnas = { "ID", "NOMBRE", "APELLIDO", "DOCUMENTO", "TELEFONO", "EMAIL", "FECHA DE NAC." };
	private List<Vendedor> lista = new ArrayList<Vendedor>();

	public void setLista(List<Vendedor> lista) {
		this.lista = lista;
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return lista.size();

	}

	@Override
	public int getColumnCount() {
		return columnas.length;
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
			return lista.get(r).getFechaNacimiento();
		case 7:
			return lista.get(r).getActivo();

		}
		return null;
	}

}
