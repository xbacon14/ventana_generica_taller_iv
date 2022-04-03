package py.edu.facitec.proyecto_ventas.modelo.dao;

import java.util.List;

import org.hibernate.query.Query;

import py.edu.facitec.proyecto_ventas.modelo.entidades.Categoria;

public class CategoriaDAO extends GenericDAO<Categoria> {

	public CategoriaDAO() {
		super(Categoria.class);
	}

	@Override
	public List<Categoria> recuperarPorFiltro(String filtro) {
		iniciarTransaccion();
		String hql = "from Categoria where UPPER(descripcion) like :descri order by id  ";
		Query<Categoria> query = getSession().createQuery(hql);
		query.setParameter("descri", "%" + filtro.toUpperCase() + "%");
		List<Categoria> result = query.getResultList();
		commit();
		return result;
	}

}
