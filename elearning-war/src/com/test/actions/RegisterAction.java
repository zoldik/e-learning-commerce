package com.test.actions;
import java.util.Map;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import org.elearning.entities.User;
import org.elearning.sessions.UserSessionLocal;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<User>, SessionAware {

//	@EJB
//	UserSessionLocal userService;
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
	
	
	
	@Override
	public String execute() throws Exception {
		try
		{
			InitialContext ctx=new InitialContext();
			UserSessionRemote userService=(UserSessionRemote)ctx.lookup("UserSession/remote");
			userService.persist((User) this.getModel());
		} 
		catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	@SkipValidation
	public String clearModel(){
		((User) getModel()).clearModel();
		return INPUT;
	}
	
	
	
	
}
