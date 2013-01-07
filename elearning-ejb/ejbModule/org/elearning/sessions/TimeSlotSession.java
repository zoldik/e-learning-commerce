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
    	return em.createQuery("select object(t) from TimeSlot as t").getResultList();
    }
    
    public TimeSlot findByBeginTime(Integer beginTime){
    	return (TimeSlot)em.createQuery("select object(t) from TimeSlot t where t.beginTime =:timeSlot")
    	.setParameter("timeSlot",beginTime)
    	.getSingleResult();
    }

}
