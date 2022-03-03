package py.edu.facitec.reutilizacion.toolbars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;

import py.edu.facitec.reutilizacion.botones.MiBoton;

public class MiToobar extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8400710974358650879L;

	public MiToobar() {

		setFloatable(false);

		MiBoton mbtnNuevo = new MiBoton();
		mbtnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mbtnNuevo.setText("Nuevo");
		mbtnNuevo.setNombreIcono("nuevo");
		add(mbtnNuevo);

		MiBoton mbtnModificar = new MiBoton();
		mbtnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mbtnModificar.setText("Modificar");
		mbtnModificar.setNombreIcono("modificar");
		add(mbtnModificar);

		MiBoton mbtnEliminar = new MiBoton();
		mbtnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mbtnEliminar.setText("Eliminar");
		mbtnEliminar.setNombreIcono("eliminar");
		add(mbtnEliminar);

		MiBoton mbtnGuardar = new MiBoton();
		mbtnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mbtnGuardar.setText("Guardar");
		mbtnGuardar.setNombreIcono("guardar");
		add(mbtnGuardar);

		MiBoton mbtnCancelar = new MiBoton();
		mbtnCancelar.setNombreIcono("cancelar");
		mbtnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mbtnCancelar.setText("Cancelar");
		add(mbtnCancelar);
	}

}
