package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Classroom;
import org.elearning.entities.Day;
import org.elearning.entities.Session;
import org.elearning.entities.Formation;
import org.elearning.entities.Teacher;
import org.elearning.entities.TimeSlot;

/**
 * Session Bean implementation class SessionSession
 */
@Stateless
public class SessionService implements SessionServiceRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public SessionService() {
        // TODO Auto-generated constructor stub
    }
    
    public void persist(Session session){
    	em.persist(session);
    }
    
    public void edit(Session session) {
        em.merge(session);
    }

    public void remove(Session session) {
        em.remove(em.merge(session));
    }
    
    public Session find(Object id){
    	return em.find(Session.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Session> findAll(){
    	return em.createQuery("select object(o) from Session as o").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Session> findChecked(List<Integer> idx) {
		return em
				.createQuery("select object(c) from Session c where c.id in (:arrayId)")
		.setParameter("arrayId", idx).getResultList();
	}
    
    public Session findConflictualSession(Day day, Classroom classroom, TimeSlot timeSlot, Teacher teacher){
    	Session session=null;
    	try{
    		session=(Session) em.createQuery("SELECT s FROM Session s LEFT JOIN s.timeSlot t LEFT JOIN s.day d LEFT JOIN s.classroom c LEFT JOIN s.teacher tch where t=:timeslot and d=:day and (c=:classroom or tch=:teacher)")
        	.setParameter("timeslot", timeSlot)
        	.setParameter("day", day)
        	.setParameter("classroom", classroom)
        	.setParameter("teacher", teacher)
        	.getSingleResult();
    	}catch (NoResultException exception) {
		};
    	return session;
    }

}
