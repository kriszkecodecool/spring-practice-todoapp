package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Todo;

@Repository
public class TodoDaoImpl implements TodoDao {
	@Autowired
	private SessionFactory sessionFactory;

	private org.hibernate.Transaction tx;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insert(Todo todo) {
		getSession().save(todo);
	}

	public List<Todo> selectAll() {
		return getSession().createQuery("from Todo").getResultList();
	}

	public Todo select(int id) {
		return getSession().get(Todo.class, id);

	}

}
