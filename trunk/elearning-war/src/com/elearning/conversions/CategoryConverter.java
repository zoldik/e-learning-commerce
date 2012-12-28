package com.elearning.conversions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.util.StrutsTypeConverter;
import org.elearning.entities.Category;
import org.elearning.entities.Formation;
import org.elearning.sessions.CategorySessionRemote;
import org.elearning.sessions.FormationSessionRemote;

public class CategoryConverter extends StrutsTypeConverter{

	private CategorySessionRemote categoryService;
	
	public CategoryConverter() throws NamingException{
		InitialContext ctx = new InitialContext();
		categoryService = (CategorySessionRemote) ctx.lookup("CategorySession/remote");
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String value= arg1[0];
		if(value!=null){
			Category category = categoryService.find(Integer.parseInt(value));
			return category;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1 instanceof Date){
			Category category= (Category)arg1;
			return String.valueOf(category.getId());
		}
		return null;
	}
	
	

}
