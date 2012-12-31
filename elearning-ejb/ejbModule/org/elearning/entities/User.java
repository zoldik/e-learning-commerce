package org.elearning.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.jboss.security.Util;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("user")
public class User implements Serializable,UserInterface{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	
	@Column(name = "first_name")
	protected String firstName;
	
	@Column(name = "last_name")
	protected String lastName;
	
	@Column(name = "username", unique=true)
	protected String username;
	
	private String password;
	
	protected String adress;
	
	@Column(name = "email", unique=true)
	protected String email;
	
	@Column(name = "phone")
	protected String phone;
	
	@Column(name = "fax")
	protected String fax;
	
	@Column(name="enabled")
	protected Boolean enabled;
	
	@ManyToOne(targetEntity=Group.class)
	@JoinColumn(name="group_id", referencedColumnName="id")
	protected Group group;
	
	@ManyToMany(targetEntity=Role.class,mappedBy="users")
	@LazyCollection(LazyCollectionOption.FALSE)
	protected Collection<Role> roles;
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	protected Date createdAt;
	
	@Temporal(TemporalType.DATE)
	@Column(name="updated_at")
	protected Date updatedAt;
	
	@Temporal(TemporalType.DATE)
	@Column(name="last_login")
	protected Date lastLogin;

	public User() {
		super();
	}

	
	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getAdress() {
		return adress;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Collection<Role> getRoles() {
		this.roles.size();
		return roles;
	}


	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}


	@PreUpdate
	public void onUpdate(){
		this.updatedAt=new Date();
	}
	
	@PrePersist
	public void onCreate(){
		this.createdAt=new Date();
		this.updatedAt=new Date();
	}
	
	public void clearModel(){
		this.email=null;
		this.firstName=null;
		this.lastName=null;
		this.password=null;
		this.password=null;
	}
}
