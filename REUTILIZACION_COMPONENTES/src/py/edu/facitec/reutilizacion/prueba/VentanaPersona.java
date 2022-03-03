package py.edu.facitec.reutilizacion.prueba;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import py.edu.facitec.reutilizacion.ventanas.VentanaGenerica;

public class VentanaPersona extends VentanaGenerica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4284765598156789362L;
	private JLabel lblNewLabel;
	private JLabel lblApellido;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPersona dialog = new VentanaPersona();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPersona() {

		lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(12, 35, 56, 16);
		getPanelFormulario().add(lblNewLabel);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(12, 86, 56, 16);
		getPanelFormulario().add(lblApellido);

		textField = new JTextField();
		textField.setBounds(80, 32, 270, 22);
		getPanelFormulario().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 83, 270, 22);
		getPanelFormulario().add(textField_1);

	}

	public String setTitutloVentana() {
		return "Registro de personas";
	}

	public String getTituloPanel() {
		return "Datos de la persona";
	}

}
