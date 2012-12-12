package org.elearning.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class HiringRequest implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String status;
	private Client clint;

	public HiringRequest() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setClint(Client clint) {
		this.clint = clint;
	}

	@ManyToOne
	public Client getClint() {
		return clint;
	}
}
