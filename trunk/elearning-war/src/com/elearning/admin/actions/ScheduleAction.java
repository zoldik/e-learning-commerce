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
import org.elearning.entities.Schedule;
import org.elearning.entities.Teacher;
import org.elearning.entities.User;
import org.elearning.sessions.AffiliateSessionRemote;
import org.elearning.sessions.ClassroomSessionRemote;
import org.elearning.sessions.ScheduleSessionRemote;
import org.elearning.sessions.UserSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScheduleAction extends ActionSupport implements
		ModelDriven<Schedule>, RequestAware, ParameterAware {

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Map<Integer,String> classroomSelect = new HashMap<Integer,String>();
	private Map<Integer,String> teacherSelect = new HashMap<Integer,String>();
	
	private List<Schedule> schedules = new ArrayList<Schedule>();
		
	private Schedule schedule = new Schedule();
	
	private ScheduleSessionRemote scheduleService;
	private ClassroomSessionRemote classRoomService;
	private UserSessionRemote userService;

	public ScheduleAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			scheduleService = (ScheduleSessionRemote) ctx.lookup("ScheduleSession/remote");
			classRoomService = (ClassroomSessionRemote) ctx.lookup("ClassroomSession/remote");
//			dayRoomService = (ClassroomSessionRemote) ctx.lookup("DaySession/remote");
//			Service = (ClassroomSessionRemote) ctx.lookup("ClassroomSession/remote");
			userService = (UserSessionRemote) ctx.lookup("TeacherSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Schedule getModel() {
		// TODO Auto-generated method stub
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
		String[] dayParameter = parameters.get("day");
		String[] teacherParameter = parameters.get("teacher");
		String[] classRoomParameter = parameters.get("classRoom");
		String[] subjectParameter = parameters.get("subject");
//		Day day =
		return SUCCESS;
	}
	
	public String input(){
		List<Classroom> rooms=classRoomService.findAll();
		for(Classroom room : rooms){
			this.classroomSelect.put(room.getId(), room.getName());
		}
		
		List<User> teachers=userService.findAll();
		for(User teacher : teachers){
			this.teacherSelect.put(teacher.getId(), teacher.getFirstName()+" "+teacher.getLastName());
		}
		
		return INPUT;
	}

	/**
	 * To list all schedules.
	 * 
	 * @return String
	 */
	public String list() {
		schedules = scheduleService.findAll();
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		 this.parameters = parameters;
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
	
}
