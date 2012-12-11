package org.elearning.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Role implements Serializable {

	@Id
	private String type;
	private Group group;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@ManyToOne
	public Group getGroup() {
		return group;
	}

}
