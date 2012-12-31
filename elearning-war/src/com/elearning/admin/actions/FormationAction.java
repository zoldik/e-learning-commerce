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
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elearning.entities.Administrator;
import org.elearning.entities.Affiliate;
import org.elearning.entities.Formation;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.sessions.AffiliateSessionRemote;
import org.elearning.sessions.FormationSessionRemote;

import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FormationAction extends ActionSupport implements
		ModelDriven<Formation>, RequestAware, ParameterAware, LoginRequired {

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Map<Integer,String> affiliateSelect=new HashMap<Integer,String>();
	private Formation formation = new Formation();
	private List<Formation> formations = new ArrayList<Formation>();
	private FormationSessionRemote formationService;
	private AffiliateSessionRemote affiliateService;

	public FormationAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			formationService = (FormationSessionRemote) ctx
					.lookup("FormationSession/remote");
			affiliateService = (AffiliateSessionRemote) ctx
					.lookup("AffiliateSession/remote");
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
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user instanceof Administrator) {
			formation.setAffiliate(((Administrator) user).getAffiliate());
		}
		formationService.edit(formation);
		return SUCCESS;
	}

	@SkipValidation
	public String edit() throws Exception {
		Integer id = (Integer) this.request.get("id");
		if (id > 0) {
			formation = (Formation) formationService.find(id);
		}
		return input();
	}

	/**
	 * To list all formations.
	 * 
	 * @return String
	 */
	public String list() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user instanceof Administrator) {
			formations = formationService
					.findByAffiliate(((Administrator) user).getAffiliate());
		} else {
			formations = formationService.findAll();
		}
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

	public String batch() {
		String[] checkedAll = parameters.get("all_elements");
		String[] batchAction = parameters.get("action");
		if (checkedAll[0].equals("true")) {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			User user = (User) session.get("user");
			if (user instanceof Administrator) {
				formations = formationService
						.findByAffiliate(((Administrator) user).getAffiliate());
			} else {
				formations = formationService.findAll();
			}
		} else {
			String[] checkedFormations = parameters.get("idx[]");

			List<Integer> results = new ArrayList<Integer>();
			for (int i = 0; i < checkedFormations.length; i++) {
				try {
					results.add(Integer.parseInt(checkedFormations[i]));
				} catch (NumberFormatException nfe) {
				}
				;
			}
			formations = formationService.findChecked(results);
		}

		if (batchAction[0].equals("Supprimer")) {
			for (Formation formation : formations) {
				formationService.remove(formation);
			}
		}
		return SUCCESS;
	}
	
	public String input(){
		List<Affiliate> affiliates = affiliateService.findAll();
		for(Affiliate affiliate : affiliates){
			affiliateSelect.put(affiliate.getId(), affiliate.getName());
		}
		return INPUT;
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

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

	public Map<Integer, String> getAffiliateSelect() {
		return affiliateSelect;
	}

	public void setAffiliateSelect(Map<Integer, String> affiliateSelect) {
		this.affiliateSelect = affiliateSelect;
	}
}
