package org.elearning.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String extension;
	
	@OneToMany(targetEntity = Library.class, mappedBy = "category")
	private Collection<Library> libraries;

	public Category() {
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

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Collection<Library> getLibraries() {
		return libraries;
	}

	public void setLibraries(Collection<Library> libraries) {
		this.libraries = libraries;
	}
}
