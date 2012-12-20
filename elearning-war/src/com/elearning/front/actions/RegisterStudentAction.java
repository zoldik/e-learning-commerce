package com.elearning.front.actions;
import java.util.Map;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import org.elearning.entities.Group;
import org.elearning.entities.Student;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterStudentAction extends ActionSupport implements ModelDriven<Student>, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserSessionRemote userService;
	private Map<String, Object> session;
	
	public RegisterStudentAction() throws NamingException{
		try {
			InitialContext ctx = new InitialContext();
			userService = (UserSessionRemote) ctx.lookup("UserSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student getModel() {
		if(session.get("model")==null){
			session.put("model", new Student());
		}
		return (Student)session.get("model");
			
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		Student student= this.getModel();
		student.setGroup(new Group());
		userService.persist((Student) student);
		
		return SUCCESS;
	}

	@SkipValidation
	public String clearModel(){
		((Student) getModel()).clearModel();
		return INPUT;
	}
	
	
	
	
}
