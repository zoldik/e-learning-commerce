package org.elearning.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Gouvernorate implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@OneToMany(targetEntity=Student.class,mappedBy="gouvernorate")
	private List<Student> students;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
