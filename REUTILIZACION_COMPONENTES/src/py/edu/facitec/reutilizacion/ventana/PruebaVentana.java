package py.edu.facitec.reutilizacion.ventana;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import py.edu.facitec.reutilizacion.paneles.MiPanel;
import py.edu.facitec.reutilizacion.toolbars.MiToolbar;

public class PruebaVentana extends JFrame {
	public PruebaVentana() {
		
		MiToolbar miToolbar = new MiToolbar();
		getContentPane().add(miToolbar, BorderLayout.NORTH);
		
		MiPanel miPanel = new MiPanel();
		getContentPane().add(miPanel, BorderLayout.CENTER);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4181378385723160091L;

}
