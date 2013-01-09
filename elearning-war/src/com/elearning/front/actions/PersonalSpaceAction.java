package com.elearning.front.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;
import org.elearning.entities.Affiliate;
import org.elearning.entities.Formation;
import org.elearning.entities.Student;
import org.elearning.entities.User;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionSupport;

public class PersonalSpaceAction extends ActionSupport implements SessionAware , LoginRequired {

	
	private Map<String,List<Formation>> affiliates = new HashMap<String, List<Formation>>();
	private FormationSessionRemote formationService;
	private Map<String,Object> session;
	
	
	public PersonalSpaceAction() throws NamingException{
		InitialContext ctx=new InitialContext();
		formationService= (FormationSessionRemote) ctx.lookup("FormationSession/remote");
	}
	
	public String execute(){
		Student student = (Student) session.get("user");
		if(student instanceof Student){
			Collection<Formation> formations= student.getFormations();
			for (Formation formation : formations){
				Affiliate affiliate = formation.getAffiliate();
				if(this.affiliates.containsKey(affiliate.getName())){
					this.affiliates.get(affiliate.getName()).add(formation);
				}
				else{
					ArrayList<Formation> formationList = new ArrayList<Formation>();
					formationList.add(formation);
					this.affiliates.put(affiliate.getName(), formationList);
				}
			}
			return SUCCESS;
		}
		return ERROR;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, List<Formation>> getAffiliates() {
		return affiliates;
	}

	public void setAffiliates(Map<String, List<Formation>> affiliates) {
		this.affiliates = affiliates;
	}
}
