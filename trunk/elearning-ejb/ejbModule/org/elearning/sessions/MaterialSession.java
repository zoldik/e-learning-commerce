package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Material;
import org.elearning.entities.Formation;

/**
 * Session Bean implementation class MaterialSession
 */
@Stateless
public class MaterialSession implements MaterialSessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public MaterialSession() {
        // TODO Auto-generated constructor stub
    }
    
    public void persist(Material subject){
    	em.persist(subject);
    }
    
    public void edit(Material subject) {
        em.merge(subject);
    }

    public void remove(Material subject) {
        em.remove(em.merge(subject));
    }
    
    public Material find(Object id){
    	return em.find(Material.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Material> findAll(){
    	return em.createQuery("select object(o) from Material as o").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Material> findChecked(List<Integer> idx) {
		return em
				.createQuery("select object(c) from Material c where c.id in (:arrayId)")
		.setParameter("arrayId", idx).getResultList();
	}

}
