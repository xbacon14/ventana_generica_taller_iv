package py.edu.facitec.reutilizacion.botones;

import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import py.edu.facitec.reutilizacion.utils.TextoUtil;

public class MiBoton extends JButton {
	private String nombreIcono;

	public MiBoton() {

		setForeground(new Color(178, 255, 255));
		setBackground(new Color(95, 112, 250));
		setMaximumSize(new Dimension(300, 200));
		setPreferredSize(new Dimension(300, 200));

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8647945459429944466L;

	public void setText(String text) {
		if (nombreIcono == null || nombreIcono.isEmpty()) {
			setNombreIcono(TextoUtil.normalizarText(text));

		}
		super.setText(text);
	};

	public void setNombreIcono(String nombreIcono) {
		this.nombreIcono = nombreIcono;

		try {
			URL url = MiBoton.class.getResource("/img/" + nombreIcono + ".png");
			ImageIcon icono = new ImageIcon(url);
			this.setIcon(icono);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
