package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.Classroom;
import org.elearning.entities.Day;
import org.elearning.entities.Session;
import org.elearning.entities.Teacher;
import org.elearning.entities.TimeSlot;

@Remote
public interface SessionServiceRemote extends Serializable{
	
	public void persist(Session session);
	
	public void edit(Session session);

    public void remove(Session session);
    
    public Session find(Object id);
    
    public List<Session> findAll();
    
    public List<Session> findChecked(List<Integer> idx);
    
    public Session findConflictualSession(Day day, Classroom classroom, TimeSlot timeSlot, Teacher teacher);

}
