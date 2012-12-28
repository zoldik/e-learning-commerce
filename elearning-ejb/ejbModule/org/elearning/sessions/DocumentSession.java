package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Document;
import org.elearning.entities.Formation;

/**
 * Session Bean implementation class DocumentSession
 */
@Stateless
public class DocumentSession implements DocumentSessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public DocumentSession() {
        // TODO Auto-generated constructor stub
    }
    
    public void persist(Document document){
    	em.persist(document);
    }
    
    public void edit(Document document) {
        em.merge(document);
    }

    public void remove(Document document) {
        em.remove(em.merge(document));
    }
    
    public Document find(Object id){
    	return em.find(Document.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Document> findAll(){
    	return em.createQuery("select object(o) from Document as o").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Document> findChecked(List<Integer> idx) {
		return em
				.createQuery("select object(c) from Document c where c.id in (:arrayId)")
		.setParameter("arrayId", idx).getResultList();
	}

}
