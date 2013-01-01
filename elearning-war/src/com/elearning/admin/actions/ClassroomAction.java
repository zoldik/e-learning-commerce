package com.elearning.admin.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elearning.entities.Classroom;
import org.elearning.sessions.ClassroomSessionRemote;

import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClassroomAction extends ActionSupport implements
		ModelDriven<Classroom>, RequestAware, ParameterAware, LoginRequired {

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Classroom classroom = new Classroom();
	private List<Classroom> classrooms = new ArrayList<Classroom>();
	private ClassroomSessionRemote classRoomService;

	public ClassroomAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			classRoomService = (ClassroomSessionRemote) ctx
					.lookup("ClassroomSession/remote");
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
		classRoomService.edit(classroom);
		return SUCCESS;
	}

	@SkipValidation
	public String edit() {
		Integer id = (Integer) this.request.get("id");
		if (id > 0) {
			classroom = (Classroom) classRoomService.find(id);
		}
		return this.input();
	}

	/**
	 * To list all classrooms.
	 * 
	 * @return String
	 */
	@SkipValidation
	public String list() {
		classrooms = classRoomService.findAll();
		return SUCCESS;
	}

	/**
	 * To delete a classroom.
	 * 
	 * @return String
	 */
	@SkipValidation
	public String remove() {
		classRoomService.remove(classRoomService.find(this.request.get("id")));
		return SUCCESS;
	}

	@SkipValidation
	public String batch() {
		String[] checkedAll = parameters.get("all_elements");
		String[] batchAction = parameters.get("action");
		if (checkedAll[0].equals("true")) {
			classrooms = classRoomService.findAll();
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
			classrooms = classRoomService.findChecked(results);
		}

		if (batchAction[0].equals("Supprimer")) {
			for (Classroom classroom : classrooms) {
				classRoomService.remove(classroom);
			}
		}
		return SUCCESS;
	}

	public String input() {
		return INPUT;
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
