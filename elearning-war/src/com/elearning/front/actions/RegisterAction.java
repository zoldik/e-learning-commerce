package com.elearning.front.actions;
import java.util.Map;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import org.elearning.entities.Group;
import org.elearning.entities.Student;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<Student>, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;

	@Override
	public Student getModel() {
		if(session.get("model")==null){
			session.put("model", new Teacher());
		}
		return (Student)session.get("model");
			
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
			Student user= this.getModel();
			user.setGroup(new Group());
			userService.persist(this.getModel());
		} 
		catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	@SkipValidation
	public String clearModel(){
//		((Teacher) getModel()).clearModel();
		return INPUT;
	}
	
	
	
	
}
