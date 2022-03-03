package py.edu.facitec.reutilizacion.paneles;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MiPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2971129422749774819L;
	private Image fondo;

	public void setFondo(String nombreFondo) {
		try {
			URL url = MiPanel.class.getResource("/img" + nombreFondo + ".png");
			fondo = new ImageIcon(url).getImage();
			setOpaque(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void paint(Graphics g) {
		int ancho = getWidth();
		int alto = getHeight();
		g.drawImage(fondo, 0, 0, ancho, alto, null);
	}

}
