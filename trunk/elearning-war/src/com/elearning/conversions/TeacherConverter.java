package com.elearning.conversions;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.util.StrutsTypeConverter;
import org.elearning.entities.Teacher;
import org.elearning.sessions.UserSessionRemote;

public class TeacherConverter extends StrutsTypeConverter{

	private UserSessionRemote teacherService;
	
	public TeacherConverter() throws NamingException{
		InitialContext ctx = new InitialContext();
		teacherService = (UserSessionRemote) ctx.lookup("TeacherSession/remote");
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String value= arg1[0];
		if(value!=null){
			Teacher teacher = (Teacher) teacherService.find(Integer.parseInt(value));
			return teacher;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof Teacher){
			Teacher Teacher= (Teacher)arg1;
			return String.valueOf(Teacher.getId());
		}
		return null;
	}
	
	

}
