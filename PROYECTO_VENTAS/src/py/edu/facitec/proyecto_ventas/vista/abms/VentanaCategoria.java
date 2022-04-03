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
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCategoria dialog = new VentanaCategoria();//se instancia la ventana
					dialog.setUpController();//se instancia el controlador de la ventan
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);//se visulaiza la ventana
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
		
		JLabel lblDescripcin = new JLabel("Descripci�	n");
		lblDescripcin.setBounds(12, 36, 94, 15);
		getPanelFormulario().add(lblDescripcin);
		
		textField = new JTextField();
		textField.setBounds(109, 36, 272, 19);
		getPanelFormulario().add(textField);
		textField.setColumns(10);
		//setBounds(100, 100, 450, 300);

	}

	@Override
	protected String getTitulo() {
		return "Registro de categorías";
	}

	@Override
	protected String getTituloFormulario() {
		return "Datos de la categoría";
	}

}
