package org.elearning.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class Affiliate implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@OneToMany(targetEntity = Formation.class, mappedBy = "affiliate",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	private Collection<Formation> formations;
	
	@OneToMany(targetEntity=Administrator.class, mappedBy = "affiliate",cascade=CascadeType.REMOVE)
	private Collection<Administrator> administredBy;

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

	public Collection<Formation> getFormations() {
		return formations;
	}

	public void setFormations(ArrayList<Formation> formations) {
		this.formations = formations;
	}

	public Collection<Administrator> getAdministredBy() {
		return administredBy;
	}

	public void setAdministredBy(Collection<Administrator> administredBy) {
		this.administredBy = administredBy;
	}
}
