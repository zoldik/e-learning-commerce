package com.elearning.admin.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.sessions.TeacherSessionRemote;
import org.elearning.sessions.UserSessionRemote;

import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherAction extends ActionSupport implements
		ModelDriven<Teacher>, RequestAware, ParameterAware, LoginRequired {

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Teacher teacher = new Teacher();
	private List<? extends User> teachers = new ArrayList<Teacher>();
	private UserSessionRemote userService;

	public TeacherAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			userService = (UserSessionRemote) ctx
					.lookup("TeacherSession/remote");
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
		teacher.setEnabled(true);
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
		String[] checkedAll = parameters.get("all_elements");
		String[] batchAction = parameters.get("action");
		if (checkedAll[0].equals("true")) {
			teachers = userService.findAll();
		} else {
			String[] chekedTeachers = parameters.get("idx[]");

			List<Integer> results = new ArrayList<Integer>();
			for (int i = 0; i < chekedTeachers.length; i++) {
				try {
					results.add(Integer.parseInt(chekedTeachers[i]));
				} catch (NumberFormatException nfe) {
				}
				;
			}
			teachers = userService.findChecked(results);
		}

		if (batchAction[0].equals("supprimer")) {
			for (User teacher : teachers) {
				userService.remove(teacher);
			}
		}
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

	public List<? extends User> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<? extends User> teachers) {
		this.teachers = teachers;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;

	}
}
