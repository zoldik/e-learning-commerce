package com.elearning.front.actions;

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
import org.elearning.entities.Gouvernorate;
import org.elearning.entities.Role;
import org.elearning.entities.Student;
import org.elearning.entities.User;
import org.elearning.entities.UserInterface;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.GouvernorateSessionRemote;
import org.elearning.sessions.RoleSessionRemote;
import org.elearning.sessions.UserSessionRemote;
import org.jboss.security.Util;

import com.elearning.enums.Sex;
import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class RegisterStudentAction extends ActionSupport implements
		ModelDriven<Student>, RequestAware, Preparable {

	private Map<String, Object> request;
	private Map<Integer, String> formationSelect = new HashMap<Integer,String>();
	private Map<Integer, String> gouvernorateSelect = new HashMap<Integer,String>();
	private Sex[] gender;
	private String confirmPassword;
	private Student student = new Student();
	private UserSessionRemote userService;
	private FormationSessionRemote formationService;
	private RoleSessionRemote roleService;
	private GouvernorateSessionRemote gouvernorateService;
	private Formation formation;
	private Map<Integer,String> affiliateSelect = new HashMap<Integer,String>();

	public RegisterStudentAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			userService = (UserSessionRemote) ctx
					.lookup("StudentSession/remote");
			gouvernorateService = (GouvernorateSessionRemote) ctx
			.lookup("GouvernorateSession/remote");
			formationService = (FormationSessionRemote) ctx
			.lookup("FormationSession/remote");
			roleService = (RoleSessionRemote) ctx
			.lookup("RoleSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student getModel() {
		return student;
	}
	
	public String execute() {
		addActionMessage("Votre demande d'inscription a �t� effectu�e avec succ�s. <br/> Vous recevrez un mail d'activation de votre compte et d'adh�sion � la formation dans les 24heures qui suivent. <br/><br/> Merci pour votre inscription.");
		student.setPassword(Util.createPasswordHash("MD5",
				Util.BASE64_ENCODING, null, null, student.getPassword()));
		Role role = roleService.findByName("student");
		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(role);
		student.setRoles(roles);
		student.setEnabled(true);
		userService.edit(student);
		return SUCCESS;
	}
	
	public void validate() {
		String email = this.student.getEmail();
		UserInterface user= userService.findUserByUsernameOrEmail(email);
		if(user instanceof UserInterface){
			addFieldError(this.student.getEmail(), "L'adresse email existe d�j�");
		}
		user = userService.findUserByUsernameOrEmail(this.student.getUsername());
		if(user instanceof UserInterface){
			addFieldError(this.student.getUsername(), "Le nom d'utilisateur existe d�j�");
			addActionError("Le nom d'utilisateur existe d�j�");
		}
	}

	public String input() {
		return INPUT;
	}
	
	@Override
	public void prepare() throws Exception {
		if(formation==null){
			Map<String, Object> parameters = ActionContext.getContext().getParameters();
			String[] id = (String[]) parameters.get("id");
			formation = formationService.find(Integer.parseInt(id[0]));
		}
		List<Gouvernorate> gouvernorates = new ArrayList<Gouvernorate>();
		gouvernorates = gouvernorateService.findAll();
		for (Gouvernorate gouvernorate : gouvernorates) {
			this.gouvernorateSelect.put(gouvernorate.getId(), gouvernorate.getName());
		}
		this.gender=Sex.values();
		this.formationSelect.put(formation.getId(), formation.getName());
		this.affiliateSelect .put(formation.getAffiliate().getId(),formation.getAffiliate().getName());
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Map<Integer, String> getFormationSelect() {
		return formationSelect;
	}

	public void setFormationSelect(Map<Integer, String> formationSelect) {
		this.formationSelect = formationSelect;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Map<Integer, String> getAffiliateSelect() {
		return affiliateSelect;
	}

	public void setAffiliateSelect(Map<Integer, String> affiliateSelect) {
		this.affiliateSelect = affiliateSelect;
	}

	public Map<Integer, String> getGouvernorateSelect() {
		return gouvernorateSelect;
	}

	public void setGouvernorateSelect(Map<Integer, String> gouvernorateSelect) {
		this.gouvernorateSelect = gouvernorateSelect;
	}

	public Sex[] getGender() {
		return gender;
	}

	public void setGender(Sex[] gender) {
		this.gender = gender;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}	
	
}
