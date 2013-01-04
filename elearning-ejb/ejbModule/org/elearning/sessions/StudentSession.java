package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Student;
import org.elearning.entities.Student;
import org.elearning.entities.User;
import org.elearning.entities.UserInterface;

/**
 * Session Bean implementation class StudentSession
 */
@Stateless
public class StudentSession extends UserSession implements StudentSessionRemote {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public StudentSession() {
		// TODO Auto-generated constructor stub
	}

	public Student find(Object id) {
		Student student = em.find(Student.class, id);
		student.getFormations().size();
		return student;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return em.createQuery("select object(o) from Student as o")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> findChecked(List<Integer> idx) {
		return em
				.createQuery("select t from Student as t where t.id in (:arrayId)")
		.setParameter("arrayId", idx).getResultList();
	}
}
