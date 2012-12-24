package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import org.elearning.entities.Teacher;

@Remote
public interface TeacherSessionRemote extends Serializable{
	
}
