package com.elearning.conversions;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.util.StrutsTypeConverter;
import org.elearning.entities.Gouvernorate;
import org.elearning.sessions.GouvernorateSessionRemote;

public class GouvernorateConverter extends StrutsTypeConverter{

	private GouvernorateSessionRemote gouvernorateService;
	
	public GouvernorateConverter() throws NamingException{
		InitialContext ctx = new InitialContext();
		gouvernorateService = (GouvernorateSessionRemote) ctx.lookup("GouvernorateSession/remote");
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String value= arg1[0];
		if(value!=null){
			Gouvernorate gouvernorate = gouvernorateService.find(Integer.parseInt(value));
			return gouvernorate;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof Gouvernorate){
			Gouvernorate gouvernorate= (Gouvernorate)arg1;
			return String.valueOf(gouvernorate.getId());
		}
		return null;
	}
	
	

}
