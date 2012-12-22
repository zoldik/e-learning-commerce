package com.elearning.admin.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.RequestAware;
import org.elearning.entities.Affiliate;
import org.elearning.entities.Formation;
import org.elearning.entities.User;
import org.elearning.sessions.AffiliateSessionRemote;
import org.elearning.sessions.FormationSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FormationAction extends ActionSupport implements
		ModelDriven<Formation>, RequestAware {

	private Map<String, Object> request;
	private Formation formation = new Formation();
	private HashMap<Integer, String> affiliateSelect = new HashMap<Integer,String>();
	private List<Formation> formations = new ArrayList<Formation>();
	private FormationSessionRemote formationService;
	private AffiliateSessionRemote affiliateService;

	public FormationAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			formationService = (FormationSessionRemote) ctx.lookup("FormationSession/remote");
			affiliateService = (AffiliateSessionRemote) ctx.lookup("AffiliateSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Formation getModel() {
		// TODO Auto-generated method stub
		return formation;
	}

	/**
	 * To save or update user.
	 * 
	 * @return String
	 */
	public String save() {
		formationService.edit(formation);
		return SUCCESS;
	}

	/**
	 * To save or update user.
	 * 
	 * @return String
	 */
	public String edit() {
		this.formation = (Formation) formationService.find(this.request.get("id"));
		formationService.edit(formation);
		return SUCCESS;
	}

	/**
	 * To list all users.
	 * 
	 * @return String
	 */
	public String list() {
		formations = formationService.findAll();
		return SUCCESS;
	}

	/**
	 * To delete a user.
	 * 
	 * @return String
	 */
	public String remove() {
		formationService.remove(formationService.find(this.request.get("id")));
		return SUCCESS;
	}
	
	public String popoulate(){
		List<Affiliate> affiliates = affiliateService.findAll();
		for(Affiliate affiliate : affiliates){
			affiliateSelect.put(affiliate.getId(),affiliate.getName());
		}
		return "populate";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public HashMap<Integer, String>  getAffiliateSelect() {
		return affiliateSelect;
	}

	public void setAffiliateSelect(HashMap<Integer, String>  affiliateSelect) {
		this.affiliateSelect = affiliateSelect;
	}
	
	
	

	
}
