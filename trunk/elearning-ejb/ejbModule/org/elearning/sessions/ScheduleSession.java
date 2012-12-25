package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Schedule;
import org.elearning.entities.Schedule;
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
    
    public Schedule find(Object id){
    	return em.find(Schedule.class, id);
    }
    
    public void edit(Schedule schedule) {
        em.merge(schedule);
    }

    public void remove(Schedule schedule) {
        em.remove(em.merge(schedule));
    }
    
    @SuppressWarnings("unchecked")
	public List<Schedule> findAll(){
    	return em.createQuery("select object(o) from Schedule as o").getResultList();
    }

}
