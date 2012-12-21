package com.elearning.front.actions;
import java.util.Map;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import org.elearning.entities.Group;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterStepAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String typeOfUser;	
	
	@Override
	public String execute() throws Exception {
		
		if(typeOfUser == "amine"){
			return "registerStudent";
		}			
		else{
			return "registerRecruiter";
		}
	}

	public String getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	
	
	
	
	
	
}
