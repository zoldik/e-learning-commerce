package com.elearning.conversions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.util.StrutsTypeConverter;
import org.elearning.entities.Formation;
import org.elearning.sessions.FormationSessionRemote;

public class FormationConverter extends StrutsTypeConverter{

	private FormationSessionRemote formationService;
	
	public FormationConverter() throws NamingException{
		InitialContext ctx = new InitialContext();
		formationService = (FormationSessionRemote) ctx.lookup("FormationSession/remote");
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String value= arg1[0];
		if(value!=null){
			Formation formation = formationService.find(Integer.parseInt(value));
			return formation;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1 instanceof Date){
			Formation formation= (Formation)arg1;
			return String.valueOf(formation.getId());
		}
		return null;
	}
	
	

}
