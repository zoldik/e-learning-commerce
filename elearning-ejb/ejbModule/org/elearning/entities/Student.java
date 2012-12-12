package org.elearning.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("student")
public class Student extends User implements Serializable {

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	private String situation;

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
		return this.situation;
	}

	public void setSituation(String Situation) {
		this.situation = Situation;
	}

}
