package org.elearning.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Student extends User implements Serializable {

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	private String Situation;

	public Student() {
		super();
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSituation() {
		return this.Situation;
	}

	public void setSituation(String Situation) {
		this.Situation = Situation;
	}

}
