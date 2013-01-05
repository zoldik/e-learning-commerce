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
import org.elearning.entities.Classroom;
import org.elearning.entities.Day;
import org.elearning.entities.Formation;
import org.elearning.entities.Material;
import org.elearning.entities.Schedule;
import org.elearning.entities.Session;
import org.elearning.entities.Teacher;
import org.elearning.entities.TimeSlot;
import org.elearning.entities.User;
import org.elearning.sessions.AffiliateSessionRemote;
import org.elearning.sessions.ClassroomSessionRemote;
import org.elearning.sessions.DaySessionRemote;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.MaterialSessionRemote;
import org.elearning.sessions.ScheduleSessionRemote;
import org.elearning.sessions.SessionServiceRemote;
import org.elearning.sessions.TimeSlotSessionRemote;
import org.elearning.sessions.UserSessionRemote;

import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ScheduleAction extends ActionSupport implements
		ModelDriven<Schedule>, RequestAware, ParameterAware, Preparable  {

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private List<Day> days = new ArrayList<Day>();
	private List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
	private Map<Integer,String> classroomSelect = new HashMap<Integer,String>();
	private Map<Integer,String> teacherSelect = new HashMap<Integer,String>();
	private Map<Integer,String> subjectSelect = new HashMap<Integer,String>();
	
	private Classroom classRoom;
	private Teacher teacher;
	private Day day;
	private Material subject;
	private Session session;
//	private TimeSlot timeSlot;
		
	private Schedule schedule = new Schedule();
	
	private ScheduleSessionRemote scheduleService;
	private ClassroomSessionRemote classRoomService;
	private MaterialSessionRemote subjectService;
	private FormationSessionRemote formationService;
	private DaySessionRemote dayService;
	private TimeSlotSessionRemote timeSlotService;
	private SessionServiceRemote sessionService;
	private UserSessionRemote userService;

	public ScheduleAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			scheduleService = (ScheduleSessionRemote) ctx.lookup("ScheduleSession/remote");
			classRoomService = (ClassroomSessionRemote) ctx.lookup("ClassroomSession/remote");
			subjectService = (MaterialSessionRemote) ctx.lookup("MaterialSession/remote");
			formationService = (FormationSessionRemote) ctx.lookup("FormationSession/remote");
			dayService = (DaySessionRemote) ctx.lookup("DaySession/remote");
			timeSlotService = (TimeSlotSessionRemote) ctx.lookup("TimeSlotSession/remote");
			sessionService = (SessionServiceRemote) ctx.lookup("SessionService/remote");
			userService = (UserSessionRemote) ctx.lookup("TeacherSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Schedule getModel() {
		return schedule;
	}

	/**
	 * To save or update schedule.
	 * 
	 * @return String
	 */
	public String save() {
		scheduleService.edit(schedule);
		return SUCCESS;
	}

	/**
	 * To save or update schedule.
	 * 
	 * @return String
	 */
	public String edit() {
		schedule = (Schedule) scheduleService.find(this.request.get("id"));
		scheduleService.edit(schedule);
		return SUCCESS;
	}
	
	public String execute(){
		if(this.teacher != null && this.subject != null && this.classRoom != null){
			this.schedule=subject.getFormation().getSchedule();
			this.session=new Session();
			this.session.setTeacher(teacher);
			this.session.setMaterial(subject);
			this.session.setClassroom(classRoom);
			this.session.setDay(day);
			this.session.setSchedule(schedule);
			sessionService.edit(session);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String input(){
		return INPUT;
	}
	
	@Override
	public void prepare() throws Exception {
		Integer id = (Integer) request.get("id");
		Formation formation = formationService.find(id);
		if(formation.getSchedule() == null){
			schedule = new Schedule();
			schedule.setFormation(formation);
			scheduleService.edit(schedule);
		}
		else{
			schedule=formation.getSchedule();
		}
		
		List<Classroom> rooms=classRoomService.findAll();
		for(Classroom room : rooms){
			this.classroomSelect.put(room.getId(), room.getName());
		}
		
		List<Material> subjects=formation.getSubjects();
		for(Material subject : subjects){
			this.subjectSelect.put(subject.getId(), subject.getName());
		}
		
		List<? extends User> teachers=(List<? extends User>) formation.getTeachers();
		for(User teacher : teachers){
			this.teacherSelect.put(teacher.getId(), teacher.getFirstName()+" "+teacher.getLastName());
		}
		
		days = this.dayService.findAll();
		timeSlots = this.timeSlotService.findAll();
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		 this.parameters = parameters;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Map<Integer, String> getClassroomSelect() {
		return classroomSelect;
	}

	public void setClassroomSelect(Map<Integer, String> classroomSelect) {
		this.classroomSelect = classroomSelect;
	}

	public Map<Integer, String> getTeacherSelect() {
		return teacherSelect;
	}

	public void setTeacherSelect(Map<Integer, String> teacherSelect) {
		this.teacherSelect = teacherSelect;
	}

	public Map<Integer, String> getSubjectSelect() {
		return subjectSelect;
	}

	public void setSubjectSelect(Map<Integer, String> subjectSelect) {
		this.subjectSelect = subjectSelect;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void setClassRoom(Classroom classRoom) {
		this.classRoom = classRoom;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setDay(Day day) {
		this.day = day;
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

	public void setSubject(Material subject) {
		this.subject = subject;
	}

	public Classroom getClassRoom() {
		return classRoom;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Material getSubject() {
		return subject;
	}	
}
