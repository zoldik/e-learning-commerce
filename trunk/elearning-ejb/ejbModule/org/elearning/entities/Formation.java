package org.elearning.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Formation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String duration;
	
	@ManyToOne(targetEntity=Affiliate.class)
	@JoinColumn(name="affiliate_id",referencedColumnName="id")
	private Affiliate affiliate;
	
	@OneToOne(targetEntity=Library.class)
	private Library library;
	
	private Schedule schedule;
	private ArrayList<Student> student;
	private ArrayList<Teacher> teacher;
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Affiliate getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(Affiliate affiliate) {
		this.affiliate = affiliate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date stratDate) {
		this.startDate = stratDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@OneToOne
	public Library getLibrary() {
		return library;
	}

	@OneToOne
	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@ManyToMany
	public ArrayList<Student> getStudent() {
		return student;
	}

	public void setStudent(ArrayList<Student> student) {
		this.student = student;
	}

	@ManyToMany
	public ArrayList<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(ArrayList<Teacher> teacher) {
		this.teacher = teacher;
	}

}
