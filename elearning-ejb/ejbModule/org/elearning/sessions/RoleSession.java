package org.elearning.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.elearning.entities.Role;
import org.elearning.entities.Formation;

/**
 * Session Bean implementation class RoleSession
 */
@Stateless
public class RoleSession implements RoleSessionRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public RoleSession() {
        // TODO Auto-generated constructor stub
    }
    
    public Role findByName(String name){
    	return (Role)em.createQuery("select r from Role r where r.name =:role")
    	.setParameter("role",name)
    	.getSingleResult();
    }

}
