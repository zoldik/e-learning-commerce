package org.elearning.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.eclipse.persistence.internal.oxm.schema.model.All;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

@Entity
@DiscriminatorValue("student")
public class Student extends User implements Serializable {

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	private String situation;
	
	@ManyToMany
	@JoinTable(name="student_formation",joinColumns=@JoinColumn(name="student_id"),inverseJoinColumns=@JoinColumn(name="formation_id"))
	private Collection<Formation> formations;

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

	public Collection<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Collection<Formation> formations) {
		this.formations = formations;
	}

	
}
