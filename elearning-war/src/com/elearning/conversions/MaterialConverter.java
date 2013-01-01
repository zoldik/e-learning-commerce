package com.elearning.conversions;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.util.StrutsTypeConverter;
import org.elearning.entities.Material;
import org.elearning.sessions.MaterialSessionRemote;

public class MaterialConverter extends StrutsTypeConverter{

	private MaterialSessionRemote subjectService;
	
	public MaterialConverter() throws NamingException{
		InitialContext ctx = new InitialContext();
		subjectService = (MaterialSessionRemote) ctx.lookup("MaterialSession/remote");
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String value= arg1[0];
		if(value!=null){
			Material subject = subjectService.find(Integer.parseInt(value));
			return subject;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof Material){
			Material subject= (Material)arg1;
			return String.valueOf(subject.getId());
		}
		return null;
	}
	
	

}
