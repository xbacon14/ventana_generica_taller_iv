package py.edu.facitec.reutilizacion.botomes;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;

import py.edu.facitec.reutilizacion.util.TextoUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiBoton extends JButton {
	private String nombreIcono;

	public MiBoton() {
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(46, 139, 87));
		setPreferredSize(new Dimension(120, 80));
		setMaximumSize(new Dimension(120, 80));

		super.setText("Texto");
	}

	@Override
	public void setText(String text) {
		if (nombreIcono == null || nombreIcono.isEmpty()) {
			setNombreIcono(TextoUtil.normalizarTexto(text));
		}
		super.setText(text);
	}

	// Asigna un icono al pasarle el nombre del ícono
	public void setNombreIcono(String nombreIcono) {
		this.nombreIcono = nombreIcono;

		try {
			URL url = MiBoton.class.getResource("/img/" + nombreIcono + ".png");
			ImageIcon icono = new ImageIcon(url);
			this.setIcon(icono);
		} catch (Exception e) {

		}
	}
}
