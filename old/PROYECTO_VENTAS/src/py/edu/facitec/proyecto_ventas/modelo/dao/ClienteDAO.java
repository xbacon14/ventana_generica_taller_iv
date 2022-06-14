package py.edu.facitec.proyecto_ventas.modelo.dao;

import java.util.List;

import org.hibernate.query.Query;

import py.edu.facitec.proyecto_ventas.modelo.entidades.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {

	public ClienteDAO() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Cliente> recuperarPorFiltro(String filtro) {
		iniciarTransaccion();
		String hql = "from Cliente where UPPER(nombre) like :nombreCliente order by id";
		Query<Cliente> query = getSession().createQuery(hql);
		query.setParameter("nombreCliente", "%" + filtro.toUpperCase() + "%");
		List<Cliente> result = query.getResultList();
		commit();
		return result;
	}

}
