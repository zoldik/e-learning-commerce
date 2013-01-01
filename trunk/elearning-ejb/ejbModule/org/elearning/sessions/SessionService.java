package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Session;
import org.elearning.entities.Formation;

/**
 * Session Bean implementation class SessionSession
 */
@Stateless
public class SessionService implements SessionServiceRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public SessionService() {
        // TODO Auto-generated constructor stub
    }
    
    public void persist(Session session){
    	em.persist(session);
    }
    
    public void edit(Session session) {
        em.merge(session);
    }

    public void remove(Session session) {
        em.remove(em.merge(session));
    }
    
    public Session find(Object id){
    	return em.find(Session.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Session> findAll(){
    	return em.createQuery("select object(o) from Session as o").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Session> findChecked(List<Integer> idx) {
		return em
				.createQuery("select object(c) from Session c where c.id in (:arrayId)")
		.setParameter("arrayId", idx).getResultList();
	}

}
