package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Teacher;
import org.elearning.entities.User;

/**
 * Session Bean implementation class TeacherSession
 */
@Stateless
public class TeacherSession extends UserSession {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public TeacherSession() {
		// TODO Auto-generated constructor stub
	}

	public void persist(Teacher teacher) {
		em.persist(teacher);
	}

	public void edit(Teacher teacher) {
		em.merge(teacher);
	}

	public void remove(Teacher teacher) {
		em.remove(em.merge(teacher));
	}

	public Teacher find(Object id) {
		return em.find(Teacher.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return em.createQuery("select object(o) from Teacher as o")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> findChecked(List<Integer> idx) {
		return em
				.createQuery("select t from Teacher as t where t.id in (:arrayId)")
		.setParameter("arrayId", idx).getResultList();
	}

}
