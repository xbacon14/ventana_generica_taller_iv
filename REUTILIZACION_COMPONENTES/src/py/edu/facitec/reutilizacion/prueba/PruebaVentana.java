package py.edu.facitec.reutilizacion.prueba;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import py.edu.facitec.reutilizacion.paneles.PanelFondo;
import py.edu.facitec.reutilizacion.toolbars.MiToobar;

public class PruebaVentana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8122023621283750770L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaVentana frame = new PruebaVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PruebaVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		PanelFondo panelFondo = new PanelFondo();
		panelFondo.setFondo("fondo.jpg");
		contentPane.add(panelFondo, BorderLayout.CENTER);

		MiToobar miToobar = new MiToobar();
		panelFondo.add(miToobar);
	}

}
