package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import org.elearning.entities.User;
import org.elearning.entities.UserInterface;

@Remote
public interface UserSessionRemote extends Serializable{
	
	public void persist(UserInterface user);
	
	public void edit(UserInterface user);

    public void remove(UserInterface user);
    
    public UserInterface find(Object id);
    
    public List<? extends User> findAll();
    
    public List<? extends User> findChecked(List<Integer> results);
    
    public UserInterface findUserByUsernameOrEmail(String usernmaeOrEmail);
    
    public Object login(String usernameOrEmail, String password);

}
