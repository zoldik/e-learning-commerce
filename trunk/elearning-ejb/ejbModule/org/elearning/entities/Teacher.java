package org.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("teacher")
public class Teacher extends User implements Serializable,UserInterface {

	@ManyToMany(targetEntity=Formation.class)
	@JoinTable(name="teacher_formation",joinColumns=@JoinColumn(name="teacher_id"),inverseJoinColumns=@JoinColumn(name="formation_id"))
	private Collection<Formation> formations;
	
	@OneToMany(targetEntity=Session.class, mappedBy="teacher")
	private List<Session> sessions;
	
	public Teacher() {
		super();
	}

	public Collection<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Collection<Formation> formations) {
		this.formations = formations;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
}
