package org.elearning.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
public class CV implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String experience;
	private String training;
	private String degree;
	
	@OneToOne
	Student student;
	
	@OneToOne
	External external;

	public CV() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getTraining() {
		return this.training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public External getExternal() {
		return external;
	}

	public void setExternal(External external) {
		this.external = external;
	}

}
