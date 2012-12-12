package org.elearning.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Domain implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public Domain() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
