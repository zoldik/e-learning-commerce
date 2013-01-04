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
    
    public Affiliate find(Object id){
    	return (Affiliate) em.find(Affiliate.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Affiliate> findAll(){
    	List<Affiliate> affiliates = em.createQuery("select object(o) from Affiliate as o").getResultList();
    	for(Affiliate affiliate : affiliates){
    		affiliate.getFormations().size();
    	}
    	return affiliates;
    }

}
