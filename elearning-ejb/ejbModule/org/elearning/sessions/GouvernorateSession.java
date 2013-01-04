package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Gouvernorate;
import org.elearning.entities.Formation;

/**
 * Session Bean implementation class GouvernorateSession
 */
@Stateless
public class GouvernorateSession implements GouvernorateSessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public GouvernorateSession() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
	public List<Gouvernorate> findAll(){
    	return em.createQuery("select object(o) from Gouvernorate as o order by o.name").getResultList();
    }
    
    public Gouvernorate findByName(String name){
    	return (Gouvernorate)em.createQuery("select object(d) from Gouvernorate d where d.name =:gouvernorate")
    	.setParameter("gouvernorate",name)
    	.getSingleResult();
    }
    
    public Gouvernorate find(Object id){
    	return em.find(Gouvernorate.class, id);
    }

}
