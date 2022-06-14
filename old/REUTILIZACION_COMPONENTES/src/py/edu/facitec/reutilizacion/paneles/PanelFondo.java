package py.edu.facitec.reutilizacion.paneles;

import java.awt.Graphics; 
import java.awt.Image;
import java.awt.font.GraphicAttribute;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel{
	public PanelFondo() {
	}
	private Image fondo;
	
	public void setFondo(String nombrefondo){
	try {	
		URL url = PanelFondo.class.getResource("/img/"+nombrefondo);
		fondo = new ImageIcon(url).getImage();
		
		setOpaque(false);
	}catch (Exception e){
	}
}
	public void paint(Graphics g){
		int ancho = getWidth(); 
		int alto = getHeight(); 
		g.drawImage(fondo,0,0,ancho,alto,null); 
		super.paint(g);
	}
}
