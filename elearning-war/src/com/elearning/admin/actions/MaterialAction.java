package com.elearning.admin.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elearning.entities.Administrator;
import org.elearning.entities.Document;
import org.elearning.entities.Formation;
import org.elearning.entities.Material;
import org.elearning.entities.Role;
import org.elearning.entities.User;
import org.elearning.entities.UserInterface;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.MaterialSessionRemote;

import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MaterialAction extends ActionSupport implements
		ModelDriven<Material>, RequestAware, ParameterAware, LoginRequired {

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Map<Integer, String> formationSelect = new HashMap<Integer, String>();
	private Material subject = new Material();
	private List<Material> subjects = new ArrayList<Material>();
	private MaterialSessionRemote subjectService;
	private FormationSessionRemote formationService;

	public MaterialAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			subjectService = (MaterialSessionRemote) ctx
					.lookup("MaterialSession/remote");
			formationService = (FormationSessionRemote) ctx
			.lookup("FormationSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Material getModel() {
		// TODO Auto-generated method stub
		return subject;
	}

	/**
	 * To save or update subject.
	 * 
	 * @return String
	 */
	public String save() {
		subjectService.edit(subject);
		return SUCCESS;
	}

	public String edit() {
		Integer id = (Integer) this.request.get("id");
		if (id > 0) {
			subject = (Material) subjectService.find(id);
		}
		return this.input();
	}

	/**
	 * To list all subjects.
	 * 
	 * @return String
	 */
	public String list() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user instanceof Administrator) {
			Collection<Formation> formations = formationService
					.findByAffiliate(((Administrator) user).getAffiliate());
			for (Formation formation : formations) {
				subjects.addAll(formation.getSubjects());
			}
		} else {
			subjects = subjectService.findAll();
		}

		return SUCCESS;
	}

	/**
	 * To delete a subject.
	 * 
	 * @return String
	 */
	public String remove() {
		subjectService.remove(subjectService.find(this.request.get("id")));
		return SUCCESS;
	}

	public String batch() {
		String[] checkedAll = parameters.get("all_elements");
		String[] batchAction = parameters.get("action");
		if (checkedAll[0].equals("true")) {
			subjects = subjectService.findAll();
		} else {
			String[] checkMaterials = parameters.get("idx[]");

			List<Integer> results = new ArrayList<Integer>();
			for (int i = 0; i < checkMaterials.length; i++) {
				try {
					results.add(Integer.parseInt(checkMaterials[i]));
				} catch (NumberFormatException nfe) {
				}
				;
			}
			subjects = subjectService.findChecked(results);
		}

		if (batchAction[0].equals("Supprimer")) {
			for (Material subject : subjects) {
				subjectService.remove(subject);
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

	public Material getSubject() {
		return subject;
	}

	public void setSubbject(Material subject) {
		this.subject = subject;
	}

	public List<Material> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Material> subjects) {
		this.subjects = subjects;
	}

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
