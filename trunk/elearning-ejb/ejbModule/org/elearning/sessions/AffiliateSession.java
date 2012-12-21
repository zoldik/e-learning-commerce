package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Affiliate;


/**
 * Session Bean implementation class UserSession
 */
@Stateless
public class AffiliateSession implements AffiliateSessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public AffiliateSession() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
	public List<Affiliate> findAll(){
    	return em.createQuery("select object(o) from Affiliate as o").getResultList();
    }

}