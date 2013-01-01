package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.Day;

@Remote
public interface DaySessionRemote extends Serializable{
    
    public List<Day> findAll();
    
    public Day findByName(String name);

}
