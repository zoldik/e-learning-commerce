package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.Material;

@Remote
public interface MaterialSessionRemote extends Serializable{
	
	public void persist(Material subject);
	
	public void edit(Material subject);

    public void remove(Material subject);
    
    public Material find(Object id);
    
    public List<Material> findAll();
    
    public List<Material> findChecked(List<Integer> idx);

}
