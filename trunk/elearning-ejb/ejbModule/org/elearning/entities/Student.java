package org.elearning.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.eclipse.persistence.internal.oxm.schema.model.All;

import com.elearning.enums.Sex;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

@Entity
@DiscriminatorValue("student")
public class Student extends User implements Serializable,UserInterface {
	
	private Long cin;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;
	
	private String nationality;
	
	private String situation;
	
	@Enumerated
	private Sex sex;
	
	private String zipCode;
	
	private String fixedPhone;
	
	@ManyToOne(targetEntity=Gouvernorate.class)
	@JoinColumn(name="gouvernorate_id", referencedColumnName="id")
	protected Gouvernorate gouvernorate;
	
	@ManyToMany
	@JoinTable(name="student_formation",joinColumns=@JoinColumn(name="student_id"),inverseJoinColumns=@JoinColumn(name="formation_id"))
	private Collection<Formation> formations;

	@OneToOne(targetEntity=CV.class)
	private CV cv;
	
	public Student() {
		super();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getSituation() {
		return this.situation;
	}

	public void setSituation(String Situation) {
		this.situation = Situation;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getFixedPhone() {
		return fixedPhone;
	}

	public void setFixedPhone(String fixedPhone) {
		this.fixedPhone = fixedPhone;
	}

	public Long getCin() {
		return cin;
	}

	public void setCin(Long cin) {
		this.cin = cin;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Gouvernorate getGouvernorate() {
		return gouvernorate;
	}

	public void setGouvernorate(Gouvernorate gouvernorate) {
		this.gouvernorate = gouvernorate;
	}

	public Collection<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Collection<Formation> formations) {
		this.formations = formations;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}
	
}
