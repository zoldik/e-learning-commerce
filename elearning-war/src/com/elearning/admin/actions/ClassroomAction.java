package com.elearning.admin.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.elearning.entities.Classroom;
import org.elearning.entities.Classroom;
import org.elearning.entities.Formation;
import org.elearning.sessions.AffiliateSessionRemote;
import org.elearning.sessions.ClassroomSessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClassroomAction extends ActionSupport implements
		ModelDriven<Classroom>, RequestAware, ParameterAware{

	private Map<String,Object> request;
private Map<String,String[]> parameters;
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
	
	public String batch() {
		String[] checkedAll = parameters.get("all_elements");
		String[] batchAction = parameters.get("action");
		if (checkedAll[0].equals("true")) {
			classrooms = classRoomervice.findAll();
		} else {
			String[] checkClassrooms = parameters.get("idx[]");

			List<Integer> results = new ArrayList<Integer>();
			for (int i = 0; i < checkClassrooms.length; i++) {
				try {
					results.add(Integer.parseInt(checkClassrooms[i]));
				} catch (NumberFormatException nfe) {
				}
				;
			}
			classrooms = classRoomervice.findChecked(results);
		}

		if (batchAction[0].equals("supprimer")) {
			for (Classroom classroom : classrooms) {
				classRoomervice.remove(classroom);
			}
		}
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

	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
	
}
