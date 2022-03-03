package py.edu.facitec.reutilizacion.ventanas;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import py.edu.facitec.reutilizacion.toolbars.MiToobar;

public abstract class VentanaGenerica extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5203715174960384910L;
	private JPanel panelFormulario;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField tBuscador;
	private JLabel lblBuscar;
	private MiToobar miToobar;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// VentanaGenerica dialog = new VentanaGenerica();
	// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	// dialog.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the dialog.
	 */
	public VentanaGenerica() {
		// SETEAR TAMANHO DE LA VENTANA
		setBounds(100, 100, 759, 500);
		// CENTRAR LA VENTANA
		setLocationRelativeTo(this);
		// EVITA QUE SE PIERDA EL FOCO DE LA VENTANA
		setModal(true);
		getContentPane().setLayout(null);

		// ASIGNAR TITULO
		setTitle(setTitutloVentana());

		panelFormulario = new JPanel();
		panelFormulario.setBorder(new TitledBorder(null, getTituloPanel(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFormulario.setBounds(12, 14, 400, 345);
		getContentPane().add(panelFormulario);
		panelFormulario.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(438, 23, 291, 304);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		tBuscador = new JTextField();
		tBuscador.setBounds(495, 337, 200, 22);
		getContentPane().add(tBuscador);
		tBuscador.setColumns(10);

		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(446, 340, 56, 16);
		getContentPane().add(lblBuscar);

		miToobar = new MiToobar();
		miToobar.setFloatable(false);
		miToobar.setBounds(0, 371, 745, 82);
		getContentPane().add(miToobar);

	}

	public abstract String setTitutloVentana();

	public abstract String getTituloPanel();

	public JPanel getPanelFormulario() {
		return panelFormulario;
	}

	public JTable getTable() {
		return table;
	}

	public JTextField gettBuscador() {
		return tBuscador;
	}

	public MiToobar getMiToobar() {
		return miToobar;
	}
}
