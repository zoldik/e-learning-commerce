package com.elearning.front.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.RequestAware;
import org.elearning.entities.Affiliate;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.sessions.AffiliateSessionRemote;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AffiliateAction extends ActionSupport implements
		 RequestAware {

	private Map<String, Object> request;
	private List<Affiliate> affiliates = new ArrayList<Affiliate>();
	private AffiliateSessionRemote affiiliateService;

	public AffiliateAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			affiiliateService = (AffiliateSessionRemote) ctx.lookup("AffiliateSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * To list all users.
	 * 
	 * @return String
	 */
	public String list() {
		affiliates = affiiliateService.findAll();
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public List<Affiliate> getAffiliates() {
		return affiliates;
	}
	
	public void setAffiliates(List<Affiliate> affiliates) {
		this.affiliates = affiliates;
	}
}
