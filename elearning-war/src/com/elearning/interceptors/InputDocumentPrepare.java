package com.elearning.interceptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.elearning.entities.Administrator;
import org.elearning.entities.Document;
import org.elearning.entities.Formation;
import org.elearning.entities.Role;
import org.elearning.entities.User;
import org.elearning.entities.UserInterface;
import org.elearning.sessions.FormationSessionRemote;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.PrepareInterceptor;

public class InputDocumentPrepare implements Preparable {
	
	
	private Map<Integer, String> formationSelect = new HashMap<Integer, String>();
	private FormationSessionRemote formationService;
	
	public InputDocumentPrepare(){
		try {
			InitialContext ctx = new InitialContext();
			formationService = (FormationSessionRemote) ctx
			.lookup("FormationSession/remote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void prepare() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		List<Formation> formations = new ArrayList<Formation>();
		if (user instanceof UserInterface) {
			if (user instanceof Administrator) {
				formations = formationService
						.findByAffiliate(((Administrator) user).getAffiliate());
			} else {
				List<Role> roles = (List<Role>) user.getRoles();
				for (Role role : roles) {
					if (role.getName().equals("admin")) {
						formations = formationService.findAll();
						break;
					}
				}
			}
		}
		for (Formation formation : formations) {
			this.formationSelect.put(formation.getId(), formation.getName());
		}
	}

	public Map<Integer, String> getFormationSelect() {
		return formationSelect;
	}
}
