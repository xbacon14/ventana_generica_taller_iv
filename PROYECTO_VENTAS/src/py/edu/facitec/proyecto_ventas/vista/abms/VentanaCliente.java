package py.edu.facitec.proyecto_ventas.vista.abms;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import py.edu.facitec.proyecto_ventas.controladores.VentanaClienteController;
import py.edu.facitec.reutilizacion.ventanas.VentanaGenerica;

public class VentanaCliente extends VentanaGenerica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 156849615138821667L;
	private JTextField tNombre, tApellido, tDocumento, tTelefono, tEmail, tFechaRegistro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente dialog = new VentanaCliente();
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
		new VentanaClienteController(this);
	}

	public VentanaCliente() {
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 36, 94, 15);
		getPanelFormulario().add(lblNombre);

		tNombre = new JTextField();
		tNombre.setBounds(109, 36, 272, 19);
		getPanelFormulario().add(tNombre);
		tNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(12, 60, 94, 15);
		getPanelFormulario().add(lblApellido);

		tApellido = new JTextField();
		tApellido.setBounds(109, 60, 272, 19);
		getPanelFormulario().add(tApellido);
		tApellido.setColumns(10);

		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(12, 84, 94, 15);
		getPanelFormulario().add(lblDocumento);

		tDocumento = new JTextField();
		tDocumento.setBounds(109, 84, 272, 19);
		getPanelFormulario().add(tDocumento);
		tDocumento.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(12, 108, 94, 15);
		getPanelFormulario().add(lblTelefono);

		tTelefono = new JTextField();
		tTelefono.setBounds(109, 108, 272, 19);
		getPanelFormulario().add(tTelefono);
		tTelefono.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 132, 94, 15);
		getPanelFormulario().add(lblEmail);

		tEmail = new JTextField();
		tEmail.setBounds(109, 132, 272, 19);
		getPanelFormulario().add(tEmail);
		tEmail.setColumns(10);

		JLabel lblFechaRegistro = new JLabel("Fecha de registro:");
		lblFechaRegistro.setBounds(12, 160, 144, 15);
		getPanelFormulario().add(lblFechaRegistro);

		tFechaRegistro = new JTextField();
		tFechaRegistro.setBounds(122, 160, 200, 19);
		getPanelFormulario().add(tFechaRegistro);
		tFechaRegistro.setColumns(10);

		JLabel lblActivo = new JLabel("Activo:");
		lblActivo.setBounds(12, 184, 94, 15);
		getPanelFormulario().add(lblActivo);

		// tac = new JTextField();
		// tNombre.setBounds(109, 36, 272, 19);
		// getPanelFormulario().add(tNombre);
		// tNombre.setColumns(10);
		// setBounds(100, 100, 450, 300);
	}

	@Override
	protected String getTitulo() {
		return "Registro de cliente";
	}

	@Override
	protected String getTituloFormulario() {
		return "Datos del cliente";
	}

}
