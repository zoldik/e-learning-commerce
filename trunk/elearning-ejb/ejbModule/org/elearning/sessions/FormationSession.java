package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Formation;

/**
 * Session Bean implementation class FormationSession
 */
@Stateless
public class FormationSession implements FormationSessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public FormationSession() {
        // TODO Auto-generated constructor stub
    }
    
    public void persist(Formation formation){
    	em.persist(formation);
    }
    
    public void edit(Formation formation) {
        em.merge(formation);
    }

    public void remove(Formation formation) {
        em.remove(em.merge(formation));
    }
    
    public Formation find(Object id){
    	return em.find(Formation.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Formation> findAll(){
    	return em.createQuery("select object(o) from Formation as o").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Formation> findChecked(String[] idx){
    	return em.createQuery("select object(o) from Formation as o where o.id in :param")
    	.setParameter("param", idx)
    	.getResultList();
    }

}