package com.test.actions;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.test.beans.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<User>, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;

	@Override
	public User getModel() {
		if(session.get("model")==null){
			session.put("model", new User());
		}
		return (User)session.get("model");
			
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	@SkipValidation
	public String clearModel(){
		((User) getModel()).clearModel();
		return INPUT;
	}
	
	
	
	
}
