package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Administrator;
import org.elearning.entities.User;

/**
 * Session Bean implementation class AdministratorSession
 */
@Stateless
public class AdministratorSession extends UserSession implements AdministratorSessionRemote {
	@PersistenceContext
	EntityManager em;

	public User find(Object id) {
		return em.find(Administrator.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return em.createQuery("select object(o) from Administrator as o")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> findChecked(List<Integer> idx) {
		return em
				.createQuery("select t from Administrator as t where t.id in (:arrayId)")
		.setParameter("arrayId", idx).getResultList();
	}

}
