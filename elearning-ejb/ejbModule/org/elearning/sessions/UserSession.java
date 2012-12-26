package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.User;

/**
 * Session Bean implementation class UserSession
 */
@Stateless
public class UserSession implements UserSessionLocal,UserSessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public UserSession() {
        // TODO Auto-generated constructor stub
    }
    
    public void persist(User user){
    	em.persist(user);
    }
    
    public void edit(User user) {
        em.merge(user);
    }

    public void remove(User user) {
        em.remove(em.merge(user));
    }
    
    public User find(Object id){
    	return em.find(User.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<User> findAll(){
    	return em.createQuery("select object(o) from User as o").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<User> findChecked(List<Integer> idx){
    	return em.createQuery("select object(o) from User as o where o.id in :param")
    	.setParameter("param", idx)
    	.getResultList();
    }

}
