package py.edu.facitec.proyecto_ventas.modelo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import py.edu.facitec.proyecto_ventas.util.ConnectionHelper;

public abstract class GenericDAO<T> {

	protected Class<T> clase;

	public GenericDAO(Class<T> clase) {
		super();
		this.clase = clase;
	}

	protected Session getSession() {
		return ConnectionHelper.getSessionFactory().getCurrentSession();

	}

	protected void iniciarTransaccion() {
		if (!getSession().getTransaction().isActive()) {
			getSession().beginTransaction();

		}
	}

	public void commit() {
		getSession().flush();
		getSession().getTransaction().commit();
	}

	public void rollback() {
		getSession().getTransaction().rollback();
	}

	public void guardar(T entity) throws Exception {
		iniciarTransaccion();
		getSession().saveOrUpdate(entity);
	}

	public void eliminar(T entity) throws Exception {
		iniciarTransaccion();
		getSession().delete(entity);

	}

	public T recuperarPorId(Serializable id) {
		iniciarTransaccion();
		T result = getSession().get(clase, id);
		commit();
		return result;
	}

	public List<T> recuperarTodo() {
		iniciarTransaccion();
		String hql = "from " + clase.getName() + " order by id";
		Query<T> query = getSession().createQuery(hql);
		List<T> result = query.getResultList();
		commit();
		return result;
	}

	abstract public List<T> recuperarPorFiltro(String filtro);
}
