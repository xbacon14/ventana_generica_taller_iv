package py.edu.facitec.proyecto_ventas.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import py.edu.facitec.proyecto_ventas.modelo.entidades.Categoria;
import py.edu.facitec.proyecto_ventas.modelo.entidades.Cliente;
import py.edu.facitec.proyecto_ventas.modelo.entidades.Producto;
import py.edu.facitec.proyecto_ventas.modelo.entidades.Vendedor;

public class ConnectionHelper {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			setUp();
		return sessionFactory;
	}

	public static void setUp() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

		try {
			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(ConnectionHelper.getSessionFactory());
		Categoria cat = new Categoria();
		Cliente c = new Cliente();
		Vendedor v = new Vendedor();
		Producto p = new Producto();

		// DEFINIR DATOS PARA INSERTAR EN CATEGORIA
		cat.setDescripcion("Lacteos");

		// DEFINIR DATOS PARA INSERTAR EN CLIENTE
		c.setNombre("ITALO");
		c.setApellido("GOLIN");
		c.setDocumento("222222");
		c.setEmail("italo.galeano123@gmail.com");
		c.setTelefono("+595981383068");
		c.setFechaRegistro(Date.from(Instant.now()));

		// DEFINIR DATOS PARA INSERTAR EN VENDEDOR
		Date fechaNac = new SimpleDateFormat("dd/MM/yyyy").parse("15/10/1998");
		v.setNombre("ITALO");
		v.setApellido("GOLIN");
		v.setDocumento("4444444");
		v.setEmail("italo.galeano123@gmail.com");
		v.setTelefono("+595981383068");
		v.setFechaNacimiento(fechaNac);

		// DEFINIR DATOS PARA INSERTAR EN PRODUCTO
		p.setDescripcion("LECHE TREBOL");
		p.setCategoria(new Categoria(1));
		p.setCodigoBarra("1234567890123");
		p.setPrecioCompra(4000.0);
		p.setPrecioVenta(5000.0);

		Session session = ConnectionHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(cat);
		session.save(c);
		session.save(v);
		session.save(p);
		session.getTransaction().commit();

	}

}
