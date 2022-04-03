package py.edu.facitec.reutilizacion.toolbars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;

import py.edu.facitec.reutilizacion.botomes.MiBoton;
import py.edu.facitec.reutilizacion.interfaces.AccionesABM;

public class MiToolbar extends JToolBar implements ActionListener {
	private MiBoton mbtnNuevo;
	private MiBoton mbtnModificar;
	private MiBoton mbtnEliminar;
	
	private MiBoton mbtnCancelar;
	private MiBoton mbtnGuardar;

	private AccionesABM acciones;

	public void setAcciones(AccionesABM acciones) {
		this.acciones = acciones;
	}

	public MiToolbar() {
		setFloatable(false);

		mbtnNuevo = new MiBoton();
		mbtnNuevo.setText("Nuevo");
		add(mbtnNuevo);

		mbtnModificar = new MiBoton();
		mbtnModificar.setText("Modificar");
		add(mbtnModificar);

		mbtnEliminar = new MiBoton();
		mbtnEliminar.setText("Eliminar");
		add(mbtnEliminar);
		
		mbtnGuardar = new MiBoton();
		mbtnGuardar.setText("Guardar");
		add(mbtnGuardar);
		
		mbtnCancelar = new MiBoton();
		mbtnCancelar.setText("Cancelar");
		add(mbtnCancelar);

		setUpEvents();
		
		
	}// final del constructor

	private void setUpEvents() {
		mbtnNuevo.addActionListener(this);
		mbtnModificar.addActionListener(this);
		mbtnEliminar.addActionListener(this);
		mbtnGuardar.addActionListener(this);
		mbtnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Nuevo":
			acciones.nuevo();
			break;
		case "Modificar":
			acciones.modificar();
			break;
		case "Eliminar":
			acciones.eliminar();
			break;
		case "Guardar":
			acciones.guardar();
			break;
		case "Cancelar":
			acciones.cancelar();
			break;
		default:
			break;
		}
	}

}
