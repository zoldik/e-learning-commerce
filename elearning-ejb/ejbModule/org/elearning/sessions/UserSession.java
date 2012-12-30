package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.User;
import org.elearning.entities.UserInterface;
import org.jboss.security.Util;

/**
 * Session Bean implementation class UserSession
 */
@Stateless
public class UserSession implements UserSessionLocal, UserSessionRemote {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public UserSession() {
		// TODO Auto-generated constructor stub
	}

	public void persist(UserInterface user) {
		em.persist(user);
	}

	public void edit(UserInterface user) {
		em.merge(user);
	}

	public void remove(UserInterface user) {
		em.remove(em.merge(user));
	}

	public UserInterface find(Object id) {
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return em.createQuery("select object(o) from User as o")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> findChecked(List<Integer> idx) {
		return em
				.createQuery(
						"select object(o) from User as o where o.id in :param")
				.setParameter("param", idx).getResultList();
	}

	public Object login(String usernameOrEmail, String password) {
		String hashedPassword = Util.createPasswordHash("MD5", Util.BASE64_ENCODING, null, null, password);
		Object user = (Object) em
				.createQuery(
						"select u from User u where u.email=:p1 or u.username=:p1 and u.password=:pwd")
				.setParameter("p1", usernameOrEmail)
				.setParameter("pwd", hashedPassword)
				.getSingleResult();
		return user;
	}

}
