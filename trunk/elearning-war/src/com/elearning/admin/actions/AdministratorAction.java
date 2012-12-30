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
import org.elearning.entities.Affiliate;
import org.elearning.entities.Category;
import org.elearning.entities.Formation;
import org.elearning.entities.User;
import org.elearning.sessions.AdministratorSessionRemote;
import org.elearning.sessions.AffiliateSessionRemote;

import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdministratorAction extends ActionSupport implements
		ModelDriven<Administrator>, RequestAware, ParameterAware, LoginRequired{

	private Map<String,Object> request;
	private Map<String,String[]> parameters;
	private Administrator administrator = new Administrator();
	private List<? extends User> administrators = new ArrayList<Administrator>();
	private AdministratorSessionRemote administratorService;
	private AffiliateSessionRemote affiliateService;
	
	private Map<Integer,String> affiliateSelect = new HashMap<Integer,String>();

	public AdministratorAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			administratorService = (AdministratorSessionRemote) ctx.lookup("AdministratorSession/remote");
			affiliateService = (AffiliateSessionRemote) ctx.lookup("AffiliateSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Administrator getModel() {
		// TODO Auto-generated method stub
		return administrator;
	}

	/**
	 * To save or update administrator.
	 * 
	 * @return String
	 */
	public String save() {
		administrator.setEnabled(true);
		administratorService.edit(administrator);
		return SUCCESS;
	}

	/**
	 * To save or update administrator.
	 * 
	 * @return String
	 */
	public String edit() {
		administrator = (Administrator) administratorService.find(this.request.get("id"));
		administratorService.edit(administrator);
		return SUCCESS;
	}

	/**
	 * To list all administrators.
	 * 
	 * @return String
	 */
	public String list() {
		administrators = administratorService.findAll();
		return SUCCESS;
	}

	/**
	 * To delete a administrator.
	 * 
	 * @return String
	 */
	public String remove() {
		administratorService.remove(administratorService.find(this.request.get("id")));
		return SUCCESS;
	}
	
	public String batch() {
		String[] checkedAll = parameters.get("all_elements");
		String[] batchAction = parameters.get("action");
		if (checkedAll[0].equals("true")) {
			administrators = administratorService.findAll();
		} else {
			String[] checkAdministrators = parameters.get("idx[]");

			List<Integer> results = new ArrayList<Integer>();
			for (int i = 0; i < checkAdministrators.length; i++) {
				try {
					results.add(Integer.parseInt(checkAdministrators[i]));
				} catch (NumberFormatException nfe) {
				}
				;
			}
			administrators = administratorService.findChecked(results);
		}

		if (batchAction[0].equals("Supprimer")) {
			for (User administrator : administrators) {
				administratorService.remove(administrator);
			}
		}
		return SUCCESS;
	}
	
	public String input() {
		if((Integer)this.request.get("id")>0){
			administrator = (Administrator) administratorService.find(this.request.get("id"));
		}
		List<Affiliate> affiliates = affiliateService.findAll();
		for (Affiliate affiliate : affiliates) {
			this.affiliateSelect.put(affiliate.getId(), affiliate.getName());
		}
		
		return INPUT;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public List<? extends User> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(List<Administrator> administrators) {
		this.administrators = administrators;
	}

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
