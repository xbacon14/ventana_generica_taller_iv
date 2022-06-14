package py.edu.facitec.proyecto_ventas.vista.modelotabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import py.edu.facitec.proyecto_ventas.modelo.entidades.Categoria;

public class ModeloTablaCategoria extends AbstractTableModel {
	private String[] columnas = { "ID", "DESCRIPCIÓN" };
	private List<Categoria> lista = new ArrayList<Categoria>();

	public void setLista(List<Categoria> lista) {
		this.lista = lista;
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		// cantidad de itenes en columna
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		// cantidad de registros a mostrar que esta en el array lista
		return lista.size();
	}

	@Override
	public String getColumnName(int i) {
		// devuelve el nombre de la columna a partir de la lista de
		// descripciones de la columna
		return columnas[i];
	}

	@Override
	public Object getValueAt(int r, int c) {
		// carga los valores de la celda a partir del array de lista de
		// categoria
		switch (c) {
		case 0:
			return lista.get(r).getId();
		case 1:
			return lista.get(r).getDescripcion();

		}
		return null;
	}

}
