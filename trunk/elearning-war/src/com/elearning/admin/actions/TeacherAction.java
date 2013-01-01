package com.elearning.admin.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elearning.entities.Administrator;
import org.elearning.entities.Formation;
import org.elearning.entities.Role;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.entities.UserInterface;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.UserSessionRemote;
import org.jboss.security.Util;

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
	private Set<Teacher> teachers = (Set<Teacher>) new HashSet<Teacher>();
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
	 * To save or update teacher.
	 * 
	 * @return String
	 */
	public String save() {
		teacher.setPassword(Util.createPasswordHash("MD5",
				Util.BASE64_ENCODING, null, null, teacher.getPassword()));
		userService.edit(teacher);
		return SUCCESS;
	}

	/**
	 * To list all teachers.
	 * 
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	@SkipValidation
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
			teachers = (Set<Teacher>) userService.findAll();
		}
		return SUCCESS;
	}
	
	@SkipValidation
	public String edit() {
		Integer id = (Integer) this.request.get("id");
		if (id > 0) {
			this.teacher = (Teacher) userService.find(id);
		}
		return this.input();
	}

	/**
	 * To delete a teacher.
	 * 
	 * @return String
	 */
	@SkipValidation
	public String remove() {
		userService.remove(userService.find(this.request.get("id")));
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@SkipValidation
	public String batch() {
		String[] checkedAll = parameters.get("all_elements");
		String[] batchAction = parameters.get("action");
		if (checkedAll[0].equals("true")) {
			teachers = (Set<Teacher>) userService.findAll();
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
			teachers = (Set<Teacher>) userService.findChecked(results);
		}

		if (batchAction[0].equals("supprimer")) {
			for (User teacher : teachers) {
				userService.remove(teacher);
			}
		}
		return SUCCESS;
	}
	
	@SkipValidation
	public String activate(){
		Integer id = (Integer) this.request.get("id");
		if (id > 0) {
			teacher = (Teacher) userService.find(id);
		}
		if(teacher.getEnabled()){
			teacher.setEnabled(false);
		}
		else{
			teacher.setEnabled(true);
		}
		userService.edit(teacher);
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

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
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
