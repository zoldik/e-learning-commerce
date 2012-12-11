package org.elearning.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Teacher extends User implements Serializable {

	public Teacher() {
		super();
	}

}
