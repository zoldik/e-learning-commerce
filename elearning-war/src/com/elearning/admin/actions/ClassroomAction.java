package com.elearning.admin.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.RequestAware;
import org.elearning.entities.Classroom;
import org.elearning.entities.Classroom;
import org.elearning.sessions.AffiliateSessionRemote;
import org.elearning.sessions.ClassroomSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClassroomAction extends ActionSupport implements
		ModelDriven<Classroom>, RequestAware {

	private Map<String,Object> request;
	private Classroom classroom = new Classroom();
	private List<Classroom> classrooms = new ArrayList<Classroom>();
	private ClassroomSessionRemote classRoomervice;

	public ClassroomAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			classRoomervice = (ClassroomSessionRemote) ctx.lookup("ClassroomSession/remote");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Classroom getModel() {
		// TODO Auto-generated method stub
		return classroom;
	}

	/**
	 * To save or update classroom.
	 * 
	 * @return String
	 */
	public String save() {
		classRoomervice.edit(classroom);
		return SUCCESS;
	}

	/**
	 * To save or update classroom.
	 * 
	 * @return String
	 */
	public String edit() {
		classroom = (Classroom) classRoomervice.find(this.request.get("id"));
		classRoomervice.edit(classroom);
		return SUCCESS;
	}

	/**
	 * To list all classrooms.
	 * 
	 * @return String
	 */
	public String list() {
		classrooms = classRoomervice.findAll();
		return SUCCESS;
	}

	/**
	 * To delete a classroom.
	 * 
	 * @return String
	 */
	public String remove() {
		classRoomervice.remove(classRoomervice.find(this.request.get("id")));
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}
}
