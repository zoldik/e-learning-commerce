package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import org.elearning.entities.User;

@Remote
public interface UserSessionRemote extends Serializable{
	
	public void persist(User user);
	
	public void edit(User user);

    public void remove(User user);
    
    public User find(Object id);
    
    public List<User> findAll();
    
    public List<User> findChecked(List<Integer> results);

}
