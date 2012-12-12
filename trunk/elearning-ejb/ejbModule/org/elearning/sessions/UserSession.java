package org.elearning.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
