package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.Classroom;

@Remote
public interface ClassroomSessionRemote extends Serializable{
	
	public void persist(Classroom classroom);
	
	public void edit(Classroom classroom);

    public void remove(Classroom classroom);
    
    public Classroom find(Object id);
    
    public List<Classroom> findAll();
    
    public List<Classroom> findChecked(String[] idx);

}
