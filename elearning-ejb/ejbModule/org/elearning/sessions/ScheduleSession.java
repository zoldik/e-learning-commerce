package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Schedule;


/**
 * Session Bean implementation class UserSession
 */
@Stateless
public class ScheduleSession implements ScheduleSessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public ScheduleSession() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
	public List<Schedule> findAll(){
    	return em.createQuery("select object(o) from Schedule as o").getResultList();
    }

}
