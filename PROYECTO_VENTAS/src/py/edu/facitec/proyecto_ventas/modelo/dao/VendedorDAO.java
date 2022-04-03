package py.edu.facitec.proyecto_ventas.modelo.dao;

import java.util.List;

import org.hibernate.query.Query;

import py.edu.facitec.proyecto_ventas.modelo.entidades.Vendedor;

public class VendedorDAO extends GenericDAO<Vendedor> {

	public VendedorDAO() {
		super(Vendedor.class);
	}

	@Override
	public List<Vendedor> recuperarPorFiltro(String filtro) {
		iniciarTransaccion();
		String hql = "from Vendedor where UPPER(nombre) like :nombre order by id  ";
		Query<Vendedor> query = getSession().createQuery(hql);
		query.setParameter("nombre", "%" + filtro.toUpperCase() + "%");
		List<Vendedor> result = query.getResultList();
		commit();
		return result;
	}

}
