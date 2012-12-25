package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import org.elearning.entities.Schedule;
import org.elearning.entities.Schedule;

@Remote
public interface ScheduleSessionRemote extends Serializable{
	
	public Schedule find(Object id);
	
	public void edit(Schedule schedule);

    public void remove(Schedule schedule);
	
    public List<Schedule> findAll();
   
}
