package py.edu.facitec.proyecto_ventas.modelo.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ventas")
public class Venta {
	@Id
	@GenericGenerator(name="increment", strategy="increment")
	@GeneratedValue(generator="increment")
	private int id;
	@Column(nullable=false)
	private String tipoPago;
	@Column(nullable=false)
	private Date fechaVenta;
	
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Vendedor vendedor;
	
	@OneToMany(mappedBy="venta", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<VentaDetalle> items;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public List<VentaDetalle> getItems() {
		return items;
	}
	public void setItems(List<VentaDetalle> items) {
		this.items = items;
	}
	

}
