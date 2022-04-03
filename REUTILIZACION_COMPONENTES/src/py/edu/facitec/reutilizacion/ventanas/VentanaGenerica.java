package py.edu.facitec.reutilizacion.ventanas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import py.edu.facitec.reutilizacion.toolbars.MiToolbar;

public abstract class VentanaGenerica extends JDialog {
	private JTable table;
	private JTextField tBuscador;
	private JPanel panelFormulario;
	private MiToolbar miToolbar;


	/**
	 * Create the dialog.
	 */
	public VentanaGenerica() {
		setBounds(100, 100, 800, 600);//define el tamaño de la ventana
		
		setLocationRelativeTo(this);//centrar la ventana
		
		setModal(true);//evita que la ventana pierda el foco
		getContentPane().setLayout(null);
		
		//asignar título a la ventana
		setTitle(getTitulo());
		
		panelFormulario = new JPanel();
		panelFormulario.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), getTituloFormulario(), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelFormulario.setBounds(12, 12, 393, 385);
		getContentPane().add(panelFormulario);
		panelFormulario.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 22, 371, 362);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tBuscador = new JTextField();
		tBuscador.setBounds(480, 397, 308, 28);
		getContentPane().add(tBuscador);
		tBuscador.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(423, 403, 70, 15);
		getContentPane().add(lblBuscar);
		
		miToolbar = new MiToolbar();
		miToolbar.setBounds(12, 469, 604, 84);
		getContentPane().add(miToolbar);

	}

	protected abstract String getTituloFormulario();
	
	protected abstract String getTitulo();

	public JTable getTable() {
		return table;
	}

	public JTextField gettBuscador() {

		return tBuscador;
	}

	public JPanel getPanelFormulario() {
		return panelFormulario;
	}

	public MiToolbar getMiToolbar() {
		return miToolbar;
	}
}
