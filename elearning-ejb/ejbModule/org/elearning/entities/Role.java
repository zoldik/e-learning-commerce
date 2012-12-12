package org.elearning.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "e_role")
public class Role implements Serializable {

	@Id
	private String name;
	
//	@ManyToMany(targetEntity=Group.class)
//	@JoinTable(name="group_roles",joinColumns=@JoinColumn(name="group_id",))
//	@JoinColumn(name="affiliate_id",referencedColumnName="id")
//	private Group group;

//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setGroup(Group group) {
//		this.group = group;
//	}
//
//	@ManyToOne
//	public Group getGroup() {
//		return group;
//	}
	
	

}
