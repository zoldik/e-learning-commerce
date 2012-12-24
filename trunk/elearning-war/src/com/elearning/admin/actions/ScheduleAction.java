package com.elearning.admin.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.RequestAware;
import org.elearning.entities.Schedule;
import org.elearning.sessions.AffiliateSessionRemote;
import org.elearning.sessions.ScheduleSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScheduleAction extends ActionSupport implements
		ModelDriven<Schedule>, RequestAware {

	private Map<String, Object> request;
	private Schedule schedule = new Schedule();
	private List<Schedule> schedules = new ArrayList<Schedule>();
	private ScheduleSessionRemote scheduleService;
	private AffiliateSessionRemote affiliateService;

	public ScheduleAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			scheduleService = (ScheduleSessionRemote) ctx.lookup("ScheduleSession/remote");
			affiliateService = (AffiliateSessionRemote) ctx.lookup("AffiliateSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Schedule getModel() {
		// TODO Auto-generated method stub
		return schedule;
	}

//	/**
//	 * To save or update schedule.
//	 * 
//	 * @return String
//	 */
//	public String save() {
//		scheduleService.edit(schedule);
//		return SUCCESS;
//	}

//	/**
//	 * To save or update schedule.
//	 * 
//	 * @return String
//	 */
//	public String edit() {
//		schedule = (Schedule) scheduleService.find(this.request.get("id"));
//		scheduleService.edit(schedule);
//		return SUCCESS;
//	}

	/**
	 * To list all schedules.
	 * 
	 * @return String
	 */
	public String list() {
		schedules = scheduleService.findAll();
		return SUCCESS;
	}

//	/**
//	 * To delete a schedule.
//	 * 
//	 * @return String
//	 */
//	public String remove() {
//		scheduleService.remove(scheduleService.find(this.request.get("id")));
//		return SUCCESS;
//	}

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
}
