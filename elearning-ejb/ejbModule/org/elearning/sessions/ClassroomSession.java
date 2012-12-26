package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Classroom;
import org.elearning.entities.Formation;

/**
 * Session Bean implementation class ClassroomSession
 */
@Stateless
public class ClassroomSession implements ClassroomSessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public ClassroomSession() {
        // TODO Auto-generated constructor stub
    }
    
    public void persist(Classroom classroom){
    	em.persist(classroom);
    }
    
    public void edit(Classroom classroom) {
        em.merge(classroom);
    }

    public void remove(Classroom classroom) {
        em.remove(em.merge(classroom));
    }
    
    public Classroom find(Object id){
    	return em.find(Classroom.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Classroom> findAll(){
    	return em.createQuery("select object(o) from Classroom as o").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Classroom> findChecked(List<Integer> idx) {
		return em
				.createQuery("select object(c) from Classroom c where c.id in (:arrayId)")
		.setParameter("arrayId", idx).getResultList();
	}

}
