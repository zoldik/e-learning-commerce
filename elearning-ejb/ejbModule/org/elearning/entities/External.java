package org.elearning.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class External extends User implements Serializable,UserInterface {

	public External() {
		super();
	}

}
