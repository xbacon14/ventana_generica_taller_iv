package py.edu.facitec.reutilizacion.toolbars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;

import py.edu.facitec.reutilizacion.botones.MiBoton;

public class MiToolbar extends JToolBar {
	public MiToolbar() {

		MiBoton mbtnHamburguesa = new MiBoton();
		mbtnHamburguesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hamburguesa");
			}
		});
		mbtnHamburguesa.setText("Hamburguesa");
		mbtnHamburguesa.setNombreIcono("hamburguesa");
		add(mbtnHamburguesa);

		MiBoton mbtnCohete = new MiBoton();
		mbtnCohete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("cohete");
			}
		});
		mbtnCohete.setText("Cohete");
		mbtnCohete.setNombreIcono("cohete");
		add(mbtnCohete);

		MiBoton btnBolsa = new MiBoton();
		btnBolsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnBolsa.setText("Bolsa");
		btnBolsa.setNombreIcono("bolsa");
		add(btnBolsa);

		MiBoton btnControl = new MiBoton();
		btnControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnControl.setNombreIcono("control");
		btnControl.setText("Control");
		add(btnControl);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7816236679911597815L;

}
