package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.TimeSlot;
import org.elearning.entities.Formation;

/**
 * Session Bean implementation class TimeSlotSession
 */
@Stateless
public class TimeSlotSession implements TimeSlotSessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public TimeSlotSession() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
	public List<TimeSlot> findAll(){
    	return em.createQuery("select object(o) from TimeSlot as o").getResultList();
    }
    
    public TimeSlot findByName(String name){
    	return (TimeSlot)em.createQuery("select object(d) from TimeSlot d where d.name =:timeSlot")
    	.setParameter("timeSlot",name)
    	.getSingleResult();
    }

}
