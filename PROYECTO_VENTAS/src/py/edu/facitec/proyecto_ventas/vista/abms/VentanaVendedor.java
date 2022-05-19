package py.edu.facitec.proyecto_ventas.vista.abms;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import py.edu.facitec.proyecto_ventas.controladores.VentanaVendedorController;
import py.edu.facitec.reutilizacion.ventanas.VentanaGenerica;

public class VentanaVendedor extends VentanaGenerica {

	private static final long serialVersionUID = -5266122788520782258L;

	private JTextField tNombre, tApellido, tDocumento, tTelefono, tEmail, tFechaNac;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVendedor dialog = new VentanaVendedor();
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
		new VentanaVendedorController(this);
	}

	public VentanaVendedor() {
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

		tFechaNac = new JTextField();
		tFechaNac.setBounds(122, 160, 200, 19);
		getPanelFormulario().add(tFechaNac);
		tFechaNac.setColumns(10);

		JLabel lblActivo = new JLabel("Activo:");
		lblActivo.setBounds(12, 184, 94, 15);
		getPanelFormulario().add(lblActivo);

	}

	@Override
	protected String getTitulo() {
		return "Registro del cliente";
	}

	@Override
	protected String getTituloFormulario() {
		return "Datos del vendedor";
	}

	public JTextField gettNombre() {
		return tNombre;
	}

	public JTextField gettApellido() {
		return tApellido;
	}

	public JTextField gettDocumento() {
		return tDocumento;
	}

	public JTextField gettTelefono() {
		return tTelefono;
	}

	public JTextField gettEmail() {
		return tEmail;
	}

	public JTextField gettFechaNac() {
		return tFechaNac;
	}

}
