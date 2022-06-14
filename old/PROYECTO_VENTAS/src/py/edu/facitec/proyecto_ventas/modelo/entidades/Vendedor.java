package py.edu.facitec.proyecto_ventas.modelo.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="vendedores")
public class Vendedor extends Persona {
	private Date FechaNacimiento;

	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	
	

}
