package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.TimeSlot;

@Remote
public interface TimeSlotSessionRemote extends Serializable{
    
    public List<TimeSlot> findAll();
    
    public TimeSlot findByBeginTime(Integer beginTime);

}
