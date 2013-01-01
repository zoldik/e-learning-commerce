package org.elearning.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Schedule implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Formation formation;
	
	@OneToMany(targetEntity=Session.class,mappedBy="schedule",cascade=CascadeType.ALL)
	private List<Session> sessions;

	public Schedule() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Formation getFormation() {
		return formation;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	public void addSession(Session session){
		this.sessions.add(session);
	}
}
