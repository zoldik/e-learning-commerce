package com.elearning.front.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;
import org.elearning.entities.Affiliate;
import org.elearning.entities.Classroom;
import org.elearning.entities.Day;
import org.elearning.entities.Document;
import org.elearning.entities.Formation;
import org.elearning.entities.Material;
import org.elearning.entities.Schedule;
import org.elearning.entities.Student;
import org.elearning.entities.TimeSlot;
import org.elearning.entities.User;
import org.elearning.sessions.DaySessionRemote;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.TimeSlotSessionRemote;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class PersonalSpaceAction extends ActionSupport implements ParameterAware,SessionAware , LoginRequired, Preparable {

	
	private Map<String,List<Formation>> affiliates = new HashMap<String, List<Formation>>();
	private Map<String,List<Document>> documents = new HashMap<String, List<Document>>();
	private FormationSessionRemote formationService;
	private DaySessionRemote dayService;
	private Schedule schedule;
	private TimeSlotSessionRemote timeSlotService;
	private Map<String,Object> session;
	private Map<String, String[]> parameters;
	private List<Day> days = new ArrayList<Day>();
	private List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
	
	
	
	public PersonalSpaceAction() throws NamingException{
		InitialContext ctx=new InitialContext();
		dayService = (DaySessionRemote) ctx.lookup("DaySession/remote");
		timeSlotService = (TimeSlotSessionRemote) ctx.lookup("TimeSlotSession/remote");
		formationService= (FormationSessionRemote) ctx.lookup("FormationSession/remote");
	}
	
	public String execute(){
		Student student = (Student) session.get("user");
		if(student instanceof Student){
			String[] idArray=this.parameters.get("id");
			List<Formation> formations= (List<Formation>) student.getFormations();
			Formation selectedFormation = formations.get(0);
			for (Formation formation : formations){
				if(idArray!=null){
					if(formation.getId()==Integer.parseInt(idArray[0])){
						selectedFormation = formation;
					}
				}
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
			schedule=selectedFormation.getSchedule();
			List<Document> documentList = (List<Document>) selectedFormation.getDocuments();
			for(Document document : documentList){
				String categoryName = document.getCategory().getName();
				if(this.documents.containsKey(categoryName)){
					this.documents.get(categoryName).add(document);
				}
				else{
					ArrayList<Document> docs = new ArrayList<Document>();
					docs.add(document);
					this.documents.put(categoryName, docs);
				}
			}
			return SUCCESS;
		}
		return ERROR;
	}
	
	@Override
	public void prepare() throws Exception {
		days = this.dayService.findAll();
		timeSlots = this.timeSlotService.findAll();
	}
	
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
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

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}

	public List<TimeSlot> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Map<String, List<Document>> getDocuments() {
		return documents;
	}

	public void setDocuments(Map<String, List<Document>> documents) {
		this.documents = documents;
	}
}
