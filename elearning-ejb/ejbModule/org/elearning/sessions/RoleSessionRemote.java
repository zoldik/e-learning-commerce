package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.Role;

@Remote
public interface RoleSessionRemote extends Serializable{
    
    public Role findByName(String name);

}
