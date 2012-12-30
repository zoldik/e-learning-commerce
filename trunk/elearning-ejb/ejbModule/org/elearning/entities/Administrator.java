package org.elearning.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Administrator extends User implements Serializable,UserInterface {
	
	@ManyToOne(targetEntity=Affiliate.class)
	@JoinColumn(name="affiliate_id",referencedColumnName="id")
	private Affiliate affiliate;

	public Affiliate getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(Affiliate affiliate) {
		this.affiliate = affiliate;
	}

}
