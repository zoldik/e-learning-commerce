package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.Formation;

@Remote
public interface FormationSessionRemote extends Serializable{
	
	public void persist(Formation formation);
	
	public void edit(Formation formation);

    public void remove(Formation formation);
    
    public Formation find(Object id);
    
    public List<Formation> findAll();
    
    public List<Formation> findChecked(List<Integer> idx);

}
