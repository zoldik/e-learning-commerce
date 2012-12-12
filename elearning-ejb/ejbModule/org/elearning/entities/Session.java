package org.elearning.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
public class Session implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String coefficient;
	private Schedule schedule;
	private Material material;
	private Classroom classroom;
	private Teacher teacher;

	public Session() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoefficient() {
		return this.coefficient;
	}

	public void setCoefficient(String coefficient) {
		this.coefficient = coefficient;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@ManyToOne
	public Schedule getSchedule() {
		return schedule;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@ManyToOne
	public Material getMaterial() {
		return material;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@ManyToOne
	public Classroom getClassroom() {
		return classroom;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@ManyToOne
	public Teacher getTeacher() {
		return teacher;
	}

}
