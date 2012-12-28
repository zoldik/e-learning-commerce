package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Category;
import org.elearning.entities.Formation;

/**
 * Session Bean implementation class CategorySession
 */
@Stateless
public class CategorySession implements CategorySessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public CategorySession() {
        // TODO Auto-generated constructor stub
    }
    
    public void persist(Category category){
    	em.persist(category);
    }
    
    public void edit(Category category) {
        em.merge(category);
    }

    public void remove(Category category) {
        em.remove(em.merge(category));
    }
    
    public Category find(Object id){
    	return em.find(Category.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Category> findAll(){
    	return em.createQuery("select object(o) from Category as o").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Category> findChecked(List<Integer> idx) {
		return em
				.createQuery("select object(c) from Category c where c.id in (:arrayId)")
		.setParameter("arrayId", idx).getResultList();
	}

}
