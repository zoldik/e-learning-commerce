package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Classroom;

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
	public List<Classroom> findChecked(String[] idx){
    	return em.createQuery("select object(o) from Classroom as o where o.id in :param")
    	.setParameter("param", idx)
    	.getResultList();
    }

}
