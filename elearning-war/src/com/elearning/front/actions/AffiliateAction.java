package com.elearning.front.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.dispatcher.mapper.ParameterAction;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.elearning.entities.Affiliate;
import org.elearning.entities.Classroom;
import org.elearning.entities.Formation;
import org.elearning.entities.Student;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.entities.UserInterface;
import org.elearning.sessions.AffiliateSessionRemote;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AffiliateAction extends ActionSupport implements
		 RequestAware, ParameterAware{

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Affiliate affiliate = new Affiliate();
	private List<Affiliate> affiliates = new ArrayList<Affiliate>();
	private List<Formation> formationList = new ArrayList<Formation>();
	private FormationSessionRemote formationService;
	private UserSessionRemote userService;
	private AffiliateSessionRemote affiiliateService;

	public AffiliateAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			affiiliateService = (AffiliateSessionRemote) ctx.lookup("AffiliateSession/remote");
			formationService = (FormationSessionRemote) ctx
			.lookup("FormationSession/remote");
			userService = (UserSessionRemote) ctx
			.lookup("StudentSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * To list all affiliates.
	 * 
	 * @return String
	 */
	public String list() {
		affiliates = affiiliateService.findAll();
		return SUCCESS;
	}
	
	public String subscribeInFormation(){
		String[] id = this.parameters.get("id");
		if (Integer.parseInt(id[0]) > 0) {
			Formation formation = (Formation) formationService.find(Integer.parseInt(id[0]));
			Map<String,Object> session = ActionContext.getContext().getSession();
			Student user = (Student) session.get("user");
			if(user instanceof Student){
				List<Formation> formations = (List<Formation>) user.getFormations();
				formations.add(formation);
				user.setFormations(formations);
				userService.edit(user);
				return "subscribe";
			}
		}
		return ERROR;
	}
	
	public String viewAffiliate(){
		String[] id = this.parameters.get("id");
		if (Integer.parseInt(id[0]) > 0) {
			affiliate = (Affiliate) affiiliateService.find(Integer.parseInt(id[0]));
		}
		Map<String,Object> session = ActionContext.getContext().getSession();
		Student user = (Student) session.get("user");
		List<Formation> formationToRemove=new ArrayList<Formation>();
		formationList=(List<Formation>) affiliate.getFormations();
		if(user instanceof Student){
			for(Formation formation : formationList){
				for(Formation formationUser : user.getFormations()){
					if (formationUser.getId()==formation.getId()){
						formationToRemove.add(formation);
					}
				}
			}
			formationList.removeAll(formationToRemove);
		}
		return "affiliate";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public List<Affiliate> getAffiliates() {
		return affiliates;
	}
	
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
	
	public void setAffiliates(List<Affiliate> affiliates) {
		this.affiliates = affiliates;
	}
	public Affiliate getAffiliate() {
		return affiliate;
	}
	public void setAffiliate(Affiliate affiliate) {
		this.affiliate = affiliate;
	}
	public List<Formation> getFormationList() {
		return formationList;
	}
	public void setFormationList(List<Formation> formationList) {
		this.formationList = formationList;
	}
}
