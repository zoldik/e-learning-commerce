package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Day;
import org.elearning.entities.Formation;

/**
 * Session Bean implementation class DaySession
 */
@Stateless
public class DaySession implements DaySessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public DaySession() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
	public List<Day> findAll(){
    	return em.createQuery("select object(o) from Day as o").getResultList();
    }
    
    public Day findByName(String name){
    	return (Day)em.createQuery("select object(d) from Day d where d.name =:day")
    	.setParameter("day",name)
    	.getSingleResult();
    }

}
