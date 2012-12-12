package org.elearning.sessions;
import java.io.Serializable;

import javax.ejb.Local;
import javax.ejb.Remote;

import org.elearning.entities.User;

@Remote
public interface UserSessionRemote extends Serializable{
	
	public void persist(User user);

}
