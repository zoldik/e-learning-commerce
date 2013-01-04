package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.Gouvernorate;

@Remote
public interface GouvernorateSessionRemote extends Serializable{
    
    public List<Gouvernorate> findAll();
    
    public Gouvernorate findByName(String name);
    
    public Gouvernorate find(Object id);

}
