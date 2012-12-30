package com.elearning.front.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elearning.entities.Role;
import org.elearning.entities.User;
import org.elearning.entities.UserInterface;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private UserSessionRemote userService;
	private Map<String,Object> session;
	
	public LoginAction() throws NamingException{
		InitialContext ctx=new InitialContext();
		userService= (UserSessionRemote) ctx.lookup("UserSession/remote");
	}
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

	public String execute() {
		User user = (User) userService.login(this.username, this.password);
		if(user instanceof UserInterface){
			session.put("user", user);
			int i=0;
			List<String> roles = new ArrayList<String>();
			for( Role role : user.getRoles()){
				roles.add(role.getName());  
				session.put("roles", roles );
			}
			return SUCCESS;
		}
		addActionError("vérifiez votre mot de passe ou bien votre login");
		return ERROR;
	}

	@SkipValidation
	public String logout(){
		session.remove("user");
		session.remove("roles");
		return "logout";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
