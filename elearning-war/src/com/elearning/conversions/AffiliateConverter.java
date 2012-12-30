package com.elearning.conversions;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.util.StrutsTypeConverter;
import org.elearning.entities.Affiliate;
import org.elearning.sessions.AffiliateSessionRemote;

public class AffiliateConverter extends StrutsTypeConverter{

	private AffiliateSessionRemote affiliatenService;
	
	public AffiliateConverter() throws NamingException{
		InitialContext ctx = new InitialContext();
		affiliatenService = (AffiliateSessionRemote) ctx.lookup("AffiliateSession/remote");
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String value= arg1[0];
		if(value!=null){
			Affiliate affiliate = affiliatenService.find(Integer.parseInt(value));
			return affiliate;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1 instanceof Affiliate){
			Affiliate affiliaten= (Affiliate)arg1;
			return String.valueOf(affiliaten.getId());
		}
		return null;
	}
	
	

}
