package py.edu.facitec.proyecto_ventas.vista.abms;

import java.awt.EventQueue;

import javax.swing.JDialog;

import py.edu.facitec.proyecto_ventas.controladores.VentanaCategoriaController;
import py.edu.facitec.reutilizacion.ventanas.VentanaGenerica;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaCategoria extends VentanaGenerica {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2728464113050111214L;
	private JTextField tDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCategoria dialog = new VentanaCategoria();
					dialog.setUpController();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setUpController() {
		new VentanaCategoriaController(this);
	}

	/**
	 * Create the dialog.
	 */
	public VentanaCategoria() {

		JLabel lblDescripcin = new JLabel("Descripció	n");
		lblDescripcin.setBounds(12, 36, 94, 15);
		getPanelFormulario().add(lblDescripcin);

		tDescripcion = new JTextField();
		tDescripcion.setBounds(109, 36, 272, 19);
		getPanelFormulario().add(tDescripcion);
		tDescripcion.setColumns(10);
		// setBounds(100, 100, 450, 300);

	}

	@Override
	protected String getTitulo() {
		return "Registro de categorias";
	}

	public JTextField gettDescripcion() {
		return tDescripcion;
	}

	public void settDescripcion(JTextField tDescripcion) {
		this.tDescripcion = tDescripcion;
	}

	@Override
	protected String getTituloFormulario() {
		return "Datos de la categorias";
	}

}
