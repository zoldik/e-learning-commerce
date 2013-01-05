package com.elearning.conversions;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.util.StrutsTypeConverter;
import org.elearning.entities.Day;
import org.elearning.sessions.DaySessionRemote;

import com.elearning.enums.Sex;

public class SexEnumConverter extends StrutsTypeConverter{

	private DaySessionRemote dayService;
	
	public SexEnumConverter() throws NamingException{
		InitialContext ctx = new InitialContext();
		dayService = (DaySessionRemote) ctx.lookup("DaySession/remote");
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String value= arg1[0];
		if(value!=null && !value.isEmpty()){
			Sex gender = Sex.fromValue(value);
			return gender;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof Sex){
			Sex gender= (Sex)arg1;
			return gender.toString();
		}
		return null;
	}
	
	

}
