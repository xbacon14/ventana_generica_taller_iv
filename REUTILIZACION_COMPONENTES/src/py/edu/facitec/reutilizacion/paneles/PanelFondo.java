package py.edu.facitec.reutilizacion.paneles;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3371869322526752636L;
	private Image fondo;

	public PanelFondo() {
		setOpaque(false);
	}

	public void setFondo(String nombreFondo) {
		try {
			URL url = PanelFondo.class.getResource("/img/" + nombreFondo);
			fondo = new ImageIcon(url).getImage();
			repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		int ancho = this.getWidth();
		int alto = this.getHeight();
		g.drawImage(fondo, 0, 0, ancho, alto, null);
		super.paint(g);
	}
}
