package com.elearning.conversions;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.util.StrutsTypeConverter;
import org.elearning.entities.Day;
import org.elearning.sessions.DaySessionRemote;

public class DayConverter extends StrutsTypeConverter{

	private DaySessionRemote dayService;
	
	public DayConverter() throws NamingException{
		InitialContext ctx = new InitialContext();
		dayService = (DaySessionRemote) ctx.lookup("DaySession/remote");
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String value= arg1[0];
		if(value!=null){
			Day day = dayService.findByName((String)value);
			return day;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof Day){
			Day day= (Day)arg1;
			return String.valueOf(day.getId());
		}
		return null;
	}
	
	

}
