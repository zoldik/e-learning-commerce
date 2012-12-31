package com.elearning.admin.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.elearning.entities.Administrator;
import org.elearning.entities.Formation;
import org.elearning.entities.Role;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.entities.UserInterface;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.UserSessionRemote;

import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherAction extends ActionSupport implements
		ModelDriven<Teacher>, RequestAware, ParameterAware, LoginRequired {

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Map<Integer, String> formationSelect = new HashMap<Integer,String>();
	private Teacher teacher = new Teacher();
	private List<Teacher> teachers = new ArrayList<Teacher>();
	private UserSessionRemote userService;
	private FormationSessionRemote formationService;

	public TeacherAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			userService = (UserSessionRemote) ctx
					.lookup("TeacherSession/remote");
			formationService = (FormationSessionRemote) ctx
			.lookup("FormationSession/remote");
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
	 * To list all users.
	 * 
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public String list() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user instanceof Administrator) {
			List<Formation> formations = formationService.findByAffiliate(((Administrator) user).getAffiliate());
			for(Formation formation : formations){
				List<Teacher> teacherList = (List<Teacher>) formation.getTeachers();
				teachers.addAll(teacherList);
			}
		} else {
			teachers = (List<Teacher>) userService.findAll();
		}
		return SUCCESS;
	}

	public String edit() {
		Integer id = (Integer) this.request.get("id");
		if (id > 0) {
			this.teacher = (Teacher) userService.find(id);
		}
		return this.input();
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
			teachers = (List<Teacher>) userService.findAll();
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
			teachers = (List<Teacher>) userService.findChecked(results);
		}

		if (batchAction[0].equals("supprimer")) {
			for (User teacher : teachers) {
				userService.remove(teacher);
			}
		}
		return SUCCESS;
	}

	public String input() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		List<Formation> formations = new ArrayList<Formation>();
		if (user instanceof UserInterface) {
			if (user instanceof Administrator) {
				formations = formationService
						.findByAffiliate(((Administrator) user).getAffiliate());
			} else {
				List<Role> roles = (List<Role>) user.getRoles();
				for (Role role : roles) {
					if (role.getName().equals("admin")) {
						formations = formationService.findAll();
						break;
					}
				}
			}
		}
		for (Formation formation : formations) {
			this.formationSelect.put(formation.getId(), formation.getName());
		}
		return INPUT;
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

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

	public Map<Integer, String> getFormationSelect() {
		return formationSelect;
	}

	public void setFormationSelect(Map<Integer, String> formationSelect) {
		this.formationSelect = formationSelect;
	}
}
