package com.elearning.admin.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.RequestAware;
import org.elearning.entities.Formation;
import org.elearning.sessions.AffiliateSessionRemote;
import org.elearning.sessions.FormationSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FormationAction extends ActionSupport implements
		ModelDriven<Formation>, RequestAware {

	private Map<String, Object> request;
	private Formation formation = new Formation();
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
	 * To save or update formation.
	 * 
	 * @return String
	 */
	public String save() {
		formationService.edit(formation);
		return SUCCESS;
	}

	/**
	 * To save or update formation.
	 * 
	 * @return String
	 */
	public String edit() {
		formation = (Formation) formationService.find(this.request.get("id"));
		formationService.edit(formation);
		return SUCCESS;
	}

	/**
	 * To list all formations.
	 * 
	 * @return String
	 */
	public String list() {
		formations = formationService.findAll();
		return SUCCESS;
	}

	/**
	 * To delete a formation.
	 * 
	 * @return String
	 */
	public String remove() {
		formationService.remove(formationService.find(this.request.get("id")));
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
}
