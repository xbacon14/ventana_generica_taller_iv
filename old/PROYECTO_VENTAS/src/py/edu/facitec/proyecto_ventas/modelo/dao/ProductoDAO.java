package py.edu.facitec.proyecto_ventas.modelo.dao;

import java.util.List;

import org.hibernate.query.Query;

import py.edu.facitec.proyecto_ventas.modelo.entidades.Producto;

public class ProductoDAO extends GenericDAO<Producto> {

	public ProductoDAO() {
		super(Producto.class);
	}

	@Override
	public List<Producto> recuperarPorFiltro(String filtro) {
		iniciarTransaccion();
		String hql = "from Producto where UPPER(descripcion) like :descripcion order by id";
		Query<Producto> query = getSession().createQuery(hql);
		query.setParameter("descripcion", "%" + filtro.toUpperCase() + "%");
		List<Producto> result = query.getResultList();
		commit();
		return result;
	}

}
