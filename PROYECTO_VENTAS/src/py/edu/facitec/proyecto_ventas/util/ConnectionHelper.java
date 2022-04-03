package py.edu.facitec.proyecto_ventas.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConnectionHelper {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) setUp();
		return sessionFactory;
	}
	
	public static void setUp() {
		StandardServiceRegistry serviceRegistry = 
				new StandardServiceRegistryBuilder().configure().build();
		
		try {
			sessionFactory = new MetadataSources(serviceRegistry)
					.buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}
	
	/*public static void main(String[] args) {
		System.out.println(ConnectionHelper.getSessionFactory());
		Categoria cat = new Categoria();
		cat.setDescripcion("Lacteos");
		
		Session session = ConnectionHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(cat);
		session.getTransaction().commit();
	
	}*/

}
