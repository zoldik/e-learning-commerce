package com.elearning.conversions;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.util.StrutsTypeConverter;
import org.elearning.entities.TimeSlot;
import org.elearning.sessions.TimeSlotSessionRemote;

public class TimeSlotConverter extends StrutsTypeConverter{

	private TimeSlotSessionRemote timeSlotService;
	
	public TimeSlotConverter() throws NamingException{
		InitialContext ctx = new InitialContext();
		timeSlotService = (TimeSlotSessionRemote) ctx.lookup("TimeSlotSession/remote");
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String value= arg1[0];
		if(value!=null){
			TimeSlot timeSlot = timeSlotService.findByBeginTime(Integer.parseInt(value));
			return timeSlot;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof TimeSlot){
			TimeSlot timeSlot= (TimeSlot)arg1;
			return String.valueOf(timeSlot.getId());
		}
		return null;
	}
	
	

}
