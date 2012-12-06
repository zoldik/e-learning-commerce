package com.test.actions;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private String username;
	
	
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String login(){
		if(username=="amine" && password=="amine"){
			Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("logged", true);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
		
	}

}
