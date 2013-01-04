package com.elearning.front.actions;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import org.elearning.entities.Affiliate;
import org.elearning.entities.Group;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.sessions.AffiliateSessionRemote;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterFirstStepAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Affiliate> affiliates;
	private FormationSessionRemote formationService;
	private AffiliateSessionRemote affiliateService;

	public RegisterFirstStepAction() throws NamingException {
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

	private String typeOfUser;	
	
	@Override
	public String execute() throws Exception {
		
		if(typeOfUser.equals("1")){
			affiliates =affiliateService.findAll();
			return "registerStudent";
		}			
		else{
			return "registerRecruiter";
		}
	}

	public String getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

	public List<Affiliate> getAffiliates() {
		return affiliates;
	}

	public void setAffiliates(List<Affiliate> affiliates) {
		this.affiliates = affiliates;
	}
}
