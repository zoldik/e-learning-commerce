package com.elearning.conversions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String value= arg1[0];
		if(value!=null){
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
			try {
				Date date = dateFormat.parse(value);
				return date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1 instanceof Date){
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
			Date date= (Date)arg1;
			return dateFormat.format(date);
		}
		return null;
	}
	
	

}
