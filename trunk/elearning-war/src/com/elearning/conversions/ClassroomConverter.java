package com.elearning.conversions;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.util.StrutsTypeConverter;
import org.elearning.entities.Classroom;
import org.elearning.sessions.ClassroomSessionRemote;

public class ClassroomConverter extends StrutsTypeConverter{

	private ClassroomSessionRemote classRoomService;
	
	public ClassroomConverter() throws NamingException{
		InitialContext ctx = new InitialContext();
		classRoomService = (ClassroomSessionRemote) ctx.lookup("ClassroomSession/remote");
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String value= arg1[0];
		if(value!=null){
			Classroom classRoom = classRoomService.find(Integer.parseInt(value));
			return classRoom;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof Classroom){
			Classroom classRoom= (Classroom)arg1;
			return String.valueOf(classRoom.getId());
		}
		return null;
	}
	
	

}
