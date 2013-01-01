package org.elearning.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="session")
public class Session implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(targetEntity=Material.class)
	@JoinColumn(name="material_id",referencedColumnName="id")
	private Material material;
	
	@ManyToOne(targetEntity=Classroom.class)
	@JoinColumn(name="classroom_id",referencedColumnName="id")
	private Classroom classroom;
	
	@ManyToOne(targetEntity=Teacher.class)
	@JoinColumn(name="teacher_id",referencedColumnName="id")
	private Teacher teacher;
	
	@ManyToOne(targetEntity=Day.class)
	@JoinColumn(name="day_id",referencedColumnName="id")
	private Day day;
	
	@ManyToOne(targetEntity=TimeSlot.class)
	@JoinColumn(name="time_slot_id",referencedColumnName="id")
	private Day timeSlot;
	
	@ManyToOne(targetEntity=Schedule.class)
	@JoinColumn(name="schedule_id",referencedColumnName="id")
	private Schedule schedule;

	public Session() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Material getMaterial() {
		return material;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
	public Classroom getClassroom() {
		return classroom;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Day getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(Day timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
}
