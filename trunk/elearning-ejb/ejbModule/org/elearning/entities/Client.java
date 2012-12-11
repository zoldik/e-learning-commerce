package org.elearning.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
public class Client extends User implements Serializable {

	private String Organization;
	private String Domain;
	

	public Client() {
		super();
	}

	public String getOrganization() {
		return this.Organization;
	}

	public void setOrganization(String Organization) {
		this.Organization = Organization;
	}

	public String getDomain() {
		return this.Domain;
	}

	public void setDomain(String Domain) {
		this.Domain = Domain;
	}

}
