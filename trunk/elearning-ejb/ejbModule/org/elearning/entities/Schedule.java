package org.elearning.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Schedule implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Formation formation;
	
	
	private ArrayList<Session> sessionList;

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

	public void setSession(ArrayList<Session> sessionList) {
		this.sessionList = sessionList;
	}

	@OneToMany
	public ArrayList<Session> getSessionList() {
		return sessionList;
	}

}