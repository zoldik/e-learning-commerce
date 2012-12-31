package com.elearning.conversions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.util.StrutsTypeConverter;
import org.elearning.entities.Formation;
import org.elearning.sessions.FormationSessionRemote;

public class FormationsConverter extends StrutsTypeConverter{

	private FormationSessionRemote formationService;
	
	public FormationsConverter() throws NamingException{
		InitialContext ctx = new InitialContext();
		formationService = (FormationSessionRemote) ctx.lookup("FormationSession/remote");
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		Collection<Formation> formations = new ArrayList<Formation>();
		for(int i=0;i<arg1.length;i++){
			String value= arg1[i];
			if(value!=null){
				Formation formation = formationService.find(Integer.parseInt(value));
				formations.add(formation);
			}
		}
		return formations;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof Formation){
			Formation formation= (Formation)arg1;
			return String.valueOf(formation.getId());
		}
		return null;
	}
	
	

}
