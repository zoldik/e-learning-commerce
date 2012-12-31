package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Affiliate;
import org.elearning.entities.Formation;
import org.elearning.entities.User;

/**
 * Session Bean implementation class FormationSession
 */
@Stateless
public class FormationSession implements FormationSessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public FormationSession() {
        // TODO Auto-generated constructor stub
    }
    
    public void persist(Formation formation){
    	em.persist(formation);
    }
    
    public void edit(Formation formation) {
        em.merge(formation);
    }

    public void remove(Formation formation) {
        em.remove(em.merge(formation));
    }
    
    public Formation find(Object id){
    	return em.find(Formation.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Formation> findAll(){
    	List<Formation> formations = (List<Formation>)em.createQuery("select object(f) from Formation f").getResultList();
    	for(Formation formation : formations){
			formation.getDocuments().size();
			formation.getTeachers().size();
		}
    	return formations;
    }
    
    @SuppressWarnings("unchecked")
	public List<Formation> findByAffiliate(Affiliate affiliate) {
    	List<Formation> formations = (List<Formation>)em.createQuery("select object(f) from Formation f where f.affiliate =:affiliate ")
		.setParameter("affiliate", affiliate).getResultList();
		for(Formation formation : formations){
			formation.getDocuments().size();
			formation.getTeachers().size();
		}
		return formations;
	}
    
    @SuppressWarnings("unchecked")
	public List<Formation> findChecked(List<Integer> idx) {
		List<Formation> formations = em
				.createQuery("select object(f) from Formation f where f.id in (:arrayId)")
		.setParameter("arrayId", idx).getResultList();
		for(Formation formation : formations){
			formation.getDocuments().size();
		}
		return formations;
	}

}
