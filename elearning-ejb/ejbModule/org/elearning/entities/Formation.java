package org.elearning.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Formation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String duration;
	
	@ManyToOne(targetEntity=Affiliate.class)
	@JoinColumn(name="affiliate_id",referencedColumnName="id")
	private Affiliate affiliate;
	
	@OneToMany(targetEntity=Document.class)
	private Collection<Document> documents;
	
	@OneToOne(targetEntity=Schedule.class)
	private Schedule schedule;
	
	@ManyToMany(targetEntity=Student.class, mappedBy="formations")
	private Collection<Student> students;
	
	@ManyToMany(targetEntity=Teacher.class, mappedBy="formations")
	private Collection<Teacher> teachers;
	
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

	public Collection<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Collection<Document> documents) {
		this.documents = documents;
	}

	@OneToOne
	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	public Collection<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Collection<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	@PrePersist
	@PreUpdate
	public void createOrUpdateDuration(){
		int diffMilliSec = (int)(endDate.getTime() - startDate.getTime());
		int diffSeconds = diffMilliSec / 1000;
		Integer diffDays =  diffSeconds / (24 * 60 * 60);
		this.setDuration(diffDays.toString());
	}
}
