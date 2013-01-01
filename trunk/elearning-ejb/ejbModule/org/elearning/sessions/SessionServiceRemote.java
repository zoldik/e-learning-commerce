package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.Session;

@Remote
public interface SessionServiceRemote extends Serializable{
	
	public void persist(Session session);
	
	public void edit(Session session);

    public void remove(Session session);
    
    public Session find(Object id);
    
    public List<Session> findAll();
    
    public List<Session> findChecked(List<Integer> idx);

}
