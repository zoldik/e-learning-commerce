package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Library;
import org.elearning.entities.Formation;

/**
 * Session Bean implementation class LibrarySession
 */
@Stateless
public class LibrarySession implements LibrarySessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public LibrarySession() {
        // TODO Auto-generated constructor stub
    }
    
    public void persist(Library library){
    	em.persist(library);
    }
    
    public void edit(Library library) {
        em.merge(library);
    }

    public void remove(Library library) {
        em.remove(em.merge(library));
    }
    
    public Library find(Object id){
    	return em.find(Library.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Library> findAll(){
    	return em.createQuery("select object(o) from Library as o").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Library> findChecked(List<Integer> idx) {
		return em
				.createQuery("select object(c) from Library c where c.id in (:arrayId)")
		.setParameter("arrayId", idx).getResultList();
	}

}
