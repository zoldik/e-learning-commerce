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
import org.elearning.entities.User;
import org.elearning.sessions.AdministratorSessionRemote;
import org.elearning.sessions.AffiliateSessionRemote;
import org.jboss.security.Util;

import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AdministratorAction extends ActionSupport implements
		ModelDriven<Administrator>, RequestAware, ParameterAware, LoginRequired, Preparable {

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Administrator administrator = new Administrator();
	private List<? extends User> administrators = new ArrayList<Administrator>();
	private AdministratorSessionRemote administratorService;
	private AffiliateSessionRemote affiliateService;

	private Map<Integer, String> affiliateSelect = new HashMap<Integer, String>();

	public AdministratorAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			administratorService = (AdministratorSessionRemote) ctx
					.lookup("AdministratorSession/remote");
			affiliateService = (AffiliateSessionRemote) ctx
					.lookup("AffiliateSession/remote");
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
		administrator.setPassword(Util.createPasswordHash("MD5",
				Util.BASE64_ENCODING, null, null, administrator.getPassword()));
		administratorService.edit(administrator);
		return SUCCESS;
	}

	@SkipValidation
	public String edit() {
		Integer id = (Integer) this.request.get("id");
		if (id > 0) {
			administrator = (Administrator) administratorService.find(id);
		}
		return "edit";
	}

	/**
	 * To list all administrators.
	 * 
	 * @return String
	 */
	@SkipValidation
	public String list() {
		administrators = administratorService.findAll();
		return SUCCESS;
	}

	/**
	 * To delete a administrator.
	 * 
	 * @return String
	 */
	@SkipValidation
	public String remove() {
		administratorService.remove(administratorService.find(this.request
				.get("id")));
		return SUCCESS;
	}
	
	@SkipValidation
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
	
	@SkipValidation
	public String activate(){
		Integer id = (Integer) this.request.get("id");
		if (id > 0) {
			administrator = (Administrator) administratorService.find(id);
		}
		if(administrator.getEnabled()){
			administrator.setEnabled(false);
		}
		else{
			administrator.setEnabled(true);
		}
		administratorService.edit(administrator);
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		List<Affiliate> affiliates = affiliateService.findAll();
		for (Affiliate affiliate : affiliates) {
			this.affiliateSelect.put(affiliate.getId(), affiliate.getName());
		}
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
