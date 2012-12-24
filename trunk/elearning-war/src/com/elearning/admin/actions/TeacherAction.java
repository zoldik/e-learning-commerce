package com.elearning.admin.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.RequestAware;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.sessions.TeacherSessionRemote;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherAction extends ActionSupport implements
		ModelDriven<Teacher>, RequestAware {

	private Map<String, Object> request;
	private Teacher teacher = new Teacher();
	private List<User> teachers = new ArrayList<User>();
	private UserSessionRemote userService;

	public TeacherAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			userService = (UserSessionRemote) ctx.lookup("TeacherSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Teacher getModel() {
		// TODO Auto-generated method stub
		return teacher;
	}

	/**
	 * To save or update user.
	 * 
	 * @return String
	 */
	public String save() {
		userService.edit(teacher);
		return SUCCESS;
	}

	/**
	 * To save or update user.
	 * 
	 * @return String
	 */
	public String edit() {
		this.teacher = (Teacher) userService.find(this.request.get("id"));
		userService.edit(teacher);
		return SUCCESS;
	}

	/**
	 * To list all users.
	 * 
	 * @return String
	 */
	public String list() {
		teachers = userService.findAll();
		return SUCCESS;
	}

	/**
	 * To delete a user.
	 * 
	 * @return String
	 */
	public String remove() {
		userService.remove(userService.find(this.request.get("id")));
		return SUCCESS;
	}

	public String batch() {
		Object t=request.get("request");
		teachers = userService.findChecked((String[]) request.get("name"));
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<User> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<User> teachers) {
		this.teachers = teachers;
	}
}
