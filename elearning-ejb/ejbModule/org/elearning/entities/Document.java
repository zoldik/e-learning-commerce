package org.elearning.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
public class Document implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String path;
	
	@ManyToOne(targetEntity = Formation.class)
	@JoinColumn(name="formation_id",referencedColumnName="id")
	private Formation formation;
	
	
	@ManyToOne(targetEntity=Category.class)
	@JoinColumn(name="category_id",referencedColumnName="id")
	private Category category;

	public Document() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@OneToOne
	public Formation getFormation() {
		return formation;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

}
